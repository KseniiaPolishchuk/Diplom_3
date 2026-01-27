package pageobject;
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

    public void clickFieldName(){ driver.findElement(fieldName).click();}
    public void completeFieldName(String name) {
        driver.findElement(fieldName).sendKeys(name);
    }
    public void clickFieldEmail(){ driver.findElement(fieldEmail).click();}
    public void completeFieldEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }
    public void clickFieldPassword(){ driver.findElement(fieldPassword).click();}
    public void completeFieldPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }
    public void getTextWrongPassword(){
        driver.findElement(wrongPassword).getText();
        assertEquals(WRONG_PASSWORD, wrongPassword);
    }
    private void assertEquals(String wrongPassword, By wrongPassword1) {
    }
    public void clickButtonRegistration() {
        driver.findElement(buttonRegistration).click();
    }
    public void clickButtonRegistrationInRegistrationForm() {
        driver.findElement(buttonRegistrationInRegistrationForm).click();
    }
    public void clickButtonEntranceRegistrationFormAndPasswordRecovery() {
        driver.findElement(buttonEntranceRegistrationFormAndPasswordRecovery).click();
    }
}
