package tests;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import api.CreatingUser;
import pageobject.LocatorsPage;
import api.StepsCreateUser;
import browser.DriverHelper;
import pageobject.MainPage;
import pageobject.RegistrationPage;
import static api.RandomCreatingUser.*;

import java.io.IOException;

public class EntranceTest {
    private static WebDriver driver;
    public String email = RANDOM_EMAIL;
    public String password = RANDOM_PASSWORD;
    @Before
    public void beforeAll() throws IOException{
        DriverHelper driverHelper = new DriverHelper();
        driver = driverHelper.initDriver();
        CreatingUser creatingUser = new CreatingUser(RANDOM_EMAIL, RANDOM_PASSWORD, RANDOM_NAME);
        StepsCreateUser stepsCreateUser = new StepsCreateUser();
        stepsCreateUser.userCreate(creatingUser);
    }

    @Test
    @DisplayName("Вход по кнопке 'Войти в аккаунт'")
    @Description("Проверяем вход по кнопке 'Войти в аккаунт'")
    public void testEntranceLK(){
        MainPage mainPage = new MainPage(driver);
        LocatorsPage locatorsPage = new LocatorsPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        locatorsPage.openMainPage();
        mainPage.clickButtonEntranceManePage();
        registrationPage.clickFieldEmail();
        registrationPage.completeFieldEmail(email);
        registrationPage.clickFieldPassword();
        registrationPage.completeFieldPassword(password);
        locatorsPage.clickButtonEntranceLK();
        locatorsPage.getTextButtonEntranceLK(); //Завершающий шаг с ассертом
    }
    @Test
    @DisplayName("Вход по кнопке 'Войти' в личном кабинете")
    @Description("Проверяем вход по кнопке 'Войти' в личном кабинете")
    public void testEntrancePersonalAccount(){
        MainPage mainPage = new MainPage(driver);
        LocatorsPage locatorsPage = new LocatorsPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        locatorsPage.openMainPage();
        mainPage.clickButtonEntrancePersonalAccount();
        registrationPage.clickFieldEmail();
        registrationPage.completeFieldEmail(email);
        registrationPage.clickFieldPassword();
        registrationPage.completeFieldPassword(password);
        locatorsPage.clickButtonEntranceLK();
        locatorsPage.getTextButtonEntranceLK(); // Завершающий шаг с ассертом
    }
    @Test
    @DisplayName("Вход по кнопке 'Войти' в форме регистрации")
    @Description("Проверяем вход по кнопке 'Войти' в форме регистрации")
    public void testEntranceRegistrationForm(){
        MainPage mainPage = new MainPage(driver);
        LocatorsPage locatorsPage = new LocatorsPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        locatorsPage.openMainPage();
        mainPage.clickButtonEntrancePersonalAccount();
        registrationPage.clickButtonRegistration();
        registrationPage.clickButtonEntranceRegistrationFormAndPasswordRecovery();
        registrationPage.clickFieldEmail();
        registrationPage.completeFieldEmail(email);
        registrationPage.clickFieldPassword();
        registrationPage.completeFieldPassword(password);
        locatorsPage.clickButtonEntranceLK();
        locatorsPage.getTextButtonEntranceLK(); // Завершающий шаг с ассертом
    }
    @Test
    @DisplayName("Вход по кнопке 'Войти' в форме восстановления пароля")
    @Description("Проверяем вход по кнопке 'Войти' в форме восстановления пароля")
    public void testEntrancePasswordRecovery(){
        MainPage mainPage = new MainPage(driver);
        LocatorsPage locatorsPage = new LocatorsPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        locatorsPage.openMainPage();
        mainPage.clickButtonEntrancePersonalAccount();
        locatorsPage.clickButtonForgotPassword();
        registrationPage.clickButtonEntranceRegistrationFormAndPasswordRecovery();
        registrationPage.clickFieldEmail();
        registrationPage.completeFieldEmail(email);
        registrationPage.clickFieldPassword();
        registrationPage.completeFieldPassword(password);
        locatorsPage.clickButtonEntranceLK();
        locatorsPage.getTextButtonEntranceLK(); // Завершающий шаг с ассертом
    }
    @After
    public void afterCode(){
        StepsCreateUser stepsCreateUser = new StepsCreateUser();
        stepsCreateUser.userDelete();
        driver.quit();
    }
}
