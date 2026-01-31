package tests;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import browser.DriverHelper;
import pageobject.LocatorsPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;
import java.io.IOException;
import static api.RandomCreatingUser.*;

public class RegistrationTest {
    private static WebDriver driver;
    @Before
    public void beforeAll() throws IOException{
        DriverHelper driverHelper = new DriverHelper();
        driver = driverHelper.initDriver();
    }

    @Test
    @DisplayName("Регистрация")
    @Description("Проверяем возможность регистрации")
    public void testRegistration(){
        LocatorsPage locatorsPage = new LocatorsPage(driver);
        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        locatorsPage.openMainPage();
        mainPage.clickButtonEntranceManePage();
        registrationPage.clickButtonRegistration();
        registrationPage.clickFieldName();
        registrationPage.completeFieldName(RANDOM_NAME);
        registrationPage.clickFieldEmail();
        registrationPage.completeFieldEmail(RANDOM_EMAIL);
        registrationPage.clickFieldPassword();
        registrationPage.completeFieldPassword(RANDOM_PASSWORD);
        registrationPage.clickButtonRegistrationInRegistrationForm();
        registrationPage.getTextButtonInRegistrationForm(); // Завершающий шаг с ассертом
    }
    @Test
    @DisplayName("Ошибка в поле 'Пароль'")
    @Description("Проверяем появление сообщения об ошибке в поле 'Пароль' при вводе символов меньше 6")
    public void testWrongPassword(){
        MainPage mainPage = new MainPage(driver);
        LocatorsPage locatorsPage = new LocatorsPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        locatorsPage.openMainPage();
        mainPage.clickButtonEntranceManePage();
        registrationPage.clickFieldPassword();
        registrationPage.completeFieldPassword("cyfle");
        registrationPage.clickFieldEmail();
        registrationPage.getTextWrongPassword(); // Завершающий шаг с ассертом
    }
    @After
    public void afterCode(){
        driver.quit();
    }
}
