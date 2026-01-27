package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private By buttonEntranceManePage = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Войти в аккаунт']");
    private By buttonEntrancePersonalAccount = By.xpath(".//*[@href='/account']");
    private By fieldBun = By.xpath(".//span[@class='text text_type_main-default' and text()='Булки']");
    private By fieldSauces = By.xpath(".//span[@class='text text_type_main-default' and text()='Соусы']");
    private By fieldFillings = By.xpath(".//span[@class='text text_type_main-default' and text()='Начинки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonEntranceManePage() {
        driver.findElement(buttonEntranceManePage).click();
    }
    public void clickButtonEntrancePersonalAccount() {
        driver.findElement(buttonEntrancePersonalAccount).click();
    }
    public void clickFieldBun() {
        driver.findElement(fieldBun).click();
    }
    public void clickFieldSauces() {
        driver.findElement(fieldSauces).click();
    }
    public void clickFieldFillings() {
        driver.findElement(fieldFillings).click();
    }
}
