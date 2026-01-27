package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LocatorsPage {
    private WebDriver driver;
    private By buttonEntranceLK = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Войти']");
    private By buttonForgotPassword = By.xpath(".//*[@href='/forgot-password' and text()='Восстановить пароль']");

    public LocatorsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get("https://stellarburgers.education-services.ru");
    }
    public void clickButtonEntranceLK() {
        driver.findElement(buttonEntranceLK).click();
    }
    public void clickButtonForgotPassword() {
        driver.findElement(buttonForgotPassword).click();
    }

}
