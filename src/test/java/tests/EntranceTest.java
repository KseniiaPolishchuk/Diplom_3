package tests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import api.CreatingUser;
import pageobject.LocatorsPage;
import api.StepsCreateUser;
import browser.DriverHelper;
import pageobject.MainPage;
import pageobject.RegistrationPage;

import java.io.IOException;

public class EntranceTest {
    public static String email = "test_email@bk.ru";
    public static String password = "cyfle58";
    public static String name = "Roman";
    DriverHelper driverHelper = new DriverHelper();


    @Before
    public void creatingUser(){
        CreatingUser creatingUser = new CreatingUser(email, password, name);
        StepsCreateUser stepsCreateUser = new StepsCreateUser();
        stepsCreateUser.userCreate(creatingUser);
    }
    @Test
    public void testEntranceLK() throws IOException {
        WebDriver driver = driverHelper.initDriver();
        LocatorsPage locatorsPage = new LocatorsPage(driver);
        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        //Проверяем вход по кнопке "Войти в аккаунт"
        locatorsPage.openMainPage();
        mainPage.clickButtonEntranceManePage();
        registrationPage.clickFieldEmail();
        registrationPage.completeFieldEmail(email);
        registrationPage.clickFieldPassword();
        registrationPage.completeFieldPassword(password);
        locatorsPage.clickButtonEntranceLK();
    }
    @Test
    public void testEntrancePersonalAccount() throws IOException {
        WebDriver driver = driverHelper.initDriver();
        LocatorsPage locatorsPage = new LocatorsPage(driver);
        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        //Проверяем вход по кнопке "Войти" в Личном кабинете
        locatorsPage.openMainPage();
        mainPage.clickButtonEntrancePersonalAccount();
        registrationPage.clickFieldEmail();
        registrationPage.completeFieldEmail(email);
        registrationPage.clickFieldPassword();
        registrationPage.completeFieldPassword(password);
        locatorsPage.clickButtonEntranceLK();
    }
    @Test
    public void testEntranceRegistrationForm() throws IOException {
        WebDriver driver = driverHelper.initDriver();
        LocatorsPage locatorsPage = new LocatorsPage(driver);
        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        //Проверяем вход по кнопке "Войти" в форме регистрации
        locatorsPage.openMainPage();
        mainPage.clickButtonEntrancePersonalAccount();
        registrationPage.clickButtonRegistration();
        registrationPage.clickButtonEntranceRegistrationFormAndPasswordRecovery();
        registrationPage.clickFieldEmail();
        registrationPage.completeFieldEmail(email);
        registrationPage.clickFieldPassword();
        registrationPage.completeFieldPassword(password);
        locatorsPage.clickButtonEntranceLK();
    }
    @Test
    public void testEntrancePasswordRecovery() throws IOException {
        WebDriver driver = driverHelper.initDriver();
        LocatorsPage locatorsPage = new LocatorsPage(driver);
        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        //Проверяем вход по кнопке "Войти" в форме восстановления пароля
        locatorsPage.openMainPage();
        mainPage.clickButtonEntrancePersonalAccount();
        locatorsPage.clickButtonForgotPassword();
        registrationPage.clickButtonEntranceRegistrationFormAndPasswordRecovery();
        registrationPage.clickFieldEmail();
        registrationPage.completeFieldEmail(email);
        registrationPage.clickFieldPassword();
        registrationPage.completeFieldPassword(password);
        locatorsPage.clickButtonEntranceLK();
    }
    @After
    public void afterCode(){
        StepsCreateUser stepsCreateUser = new StepsCreateUser();
        stepsCreateUser.userDelete();
    }
}
