package api;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.given;

public class StepsCreateUser {
    public static RequestSpecification requestSpecification() {
        return given()
                .contentType(ContentType.JSON)
                .baseUri("https://stellarburgers.education-services.ru/");
    }
    @Step("Создание нового пользователя")
    public ValidatableResponse userCreate(CreatingUser creatingUser) {
        return  requestSpecification()
                .body(creatingUser)
                .post("/api/auth/register")
                .then();
    }
    @Step("Удаление пользователя")
    public void userDelete() {
        requestSpecification()
                .when()
                .delete("/api/auth/user")
                .then();
    }
}
