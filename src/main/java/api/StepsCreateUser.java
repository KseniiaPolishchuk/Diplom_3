package api;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static api.Endpoints.*;
import static io.restassured.RestAssured.given;

public class StepsCreateUser {
    public static RequestSpecification requestSpecification() {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL);
    }
    @Step("Создание нового пользователя")
    public ValidatableResponse userCreate(CreatingUser creatingUser) {
        return  requestSpecification()
                .body(creatingUser)
                .post(CREATE_USER)
                .then();
    }
    @Step("Удаление пользователя")
    public void userDelete() {
        requestSpecification()
                .when()
                .delete(DELETE_USER)
                .then();
    }
}
