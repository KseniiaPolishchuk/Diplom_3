package tests;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import browser.DriverHelper;
import pageobject.LocatorsPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;

import java.io.IOException;

public class RegistrationTest {

    public String name = "Роман";
    public String email = "test_email@bk.ru";
    public String password = "cyfle58";
    DriverHelper driverHelper = new DriverHelper();

    @Test
    public void testRegistration() throws IOException {

        WebDriver driver = driverHelper.initDriver();
        LocatorsPage locatorsPage = new LocatorsPage(driver);
        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        //Проверяем возможность регистрации
        locatorsPage.openMainPage();
        mainPage.clickButtonEntranceManePage();
        registrationPage.clickButtonRegistration();
        registrationPage.clickFieldName();
        registrationPage.completeFieldName(name);
        registrationPage.clickFieldEmail();
        registrationPage.completeFieldEmail(email);
        registrationPage.clickFieldPassword();
        registrationPage.completeFieldPassword(password);
        registrationPage.clickButtonRegistrationInRegistrationForm();
    }
    @Test
    public void testWrongPassword() throws IOException {
        WebDriver driver = driverHelper.initDriver();
        MainPage mainPage = new MainPage(driver);
        LocatorsPage locatorsPage = new LocatorsPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        //Проверяем наличие сообщения об ошибке в поле "Пароль" при вводе меньше 6 символов
        locatorsPage.openMainPage();
        mainPage.clickButtonEntranceManePage();
        registrationPage.clickFieldPassword();
        registrationPage.completeFieldPassword("cyfle");
        registrationPage.clickFieldEmail();
        registrationPage.getTextWrongPassword();
    }
}
