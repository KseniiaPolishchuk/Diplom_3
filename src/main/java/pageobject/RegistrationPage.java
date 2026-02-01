package pageobject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;
    private By fieldName = By.xpath(".//label[text() = 'Имя']/../input[contains(@name, 'name')]");
    private By fieldEmail = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    private By fieldPassword = By.xpath(".//input[@name='Пароль']");
    private By wrongPassword = By.xpath(".//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']");
    private static final String WRONG_PASSWORD = "Некорректный пароль";
    private By buttonRegistration = By.xpath(".//*[@href='/register' and text()='Зарегистрироваться']");
    private By buttonRegistrationInRegistrationForm = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Зарегистрироваться']");
    private By buttonEntranceRegistrationFormAndPasswordRecovery = By.xpath(".//*[@href='/login' and text()='Войти']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Нажатие на поле 'Имя'")
    public void clickFieldName(){ driver.findElement(fieldName).click();}
    @Step("Ввод текста в поле 'Имя'")
    public void completeFieldName(String name) {
        driver.findElement(fieldName).sendKeys(name);
    }
    @Step("Нажатие на поле 'Email'")
    public void clickFieldEmail(){ driver.findElement(fieldEmail).click();}
    @Step("Ввод текста в поле 'Email'")
    public void completeFieldEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }
    @Step("Нажатие на поле 'Пароль'")
    public void clickFieldPassword(){ driver.findElement(fieldPassword).click();}
    @Step("Ввод текста в поле 'Пароль'")
    public void completeFieldPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }
    @Step("Получение текста ошибки при неправильном пароле и сравнение с ожидаемым текстом")
    public void getTextWrongPassword(){
        driver.findElement(wrongPassword).getText();
        assertEquals(WRONG_PASSWORD, wrongPassword);
    }
    private void assertEquals(String wrongPassword, By wrongPasswordOne) {
    }
    @Step("Получение текста кнопки 'Зарегистрироваться' в форме регистрации и сравнение его с ожидаемым текстом")
    public void getTextButtonInRegistrationForm(){
        driver.findElement(buttonRegistrationInRegistrationForm).getText();
        assertEquals("Зарегистрироваться", buttonRegistrationInRegistrationForm);
    }
    @Step("Нажатие на кнопку 'Зарегистрироваться'")
    public void clickButtonRegistration() {
        driver.findElement(buttonRegistration).click();
    }
    @Step("Нажатие на кнопку 'Зарегистрироваться' в форме регистрации")
    public void clickButtonRegistrationInRegistrationForm() {
        driver.findElement(buttonRegistrationInRegistrationForm).click();
    }
    @Step("Нажатие на кнопку 'Войти' в форме регистрации и в форме востановления пароля")
    public void clickButtonEntranceRegistrationFormAndPasswordRecovery() {
        driver.findElement(buttonEntranceRegistrationFormAndPasswordRecovery).click();
    }
}
