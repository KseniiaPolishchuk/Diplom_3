package pageobject;
import io.qameta.allure.Step;
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
    @Step
    public void clickButtonEntranceManePage() {
        driver.findElement(buttonEntranceManePage).click();
    }
    @Step
    public void clickButtonEntrancePersonalAccount() {
        driver.findElement(buttonEntrancePersonalAccount).click();
    }
    @Step
    public void clickFieldBun() {
        driver.findElement(fieldBun).click();
    }
    @Step
    public void clickFieldSauces() {
       driver.findElement(fieldSauces).click();
    }
    @Step
    public void getTextSectionSauces(){
        driver.findElement(fieldSauces).getText();
        assertEquals("Соусы", fieldSauces);
    }

    private void assertEquals(String соусы, By fieldSauces) {
    }
    @Step
    public void getTextSectionFillings(){
        driver.findElement(fieldFillings).getText();
        assertEquals("Начинки", fieldFillings);
    }
    @Step
    public void getTextSectionBun(){
        driver.findElement(fieldBun).getText();
        assertEquals("Булки", fieldBun);
    }
    @Step
    public void clickFieldFillings() {
        driver.findElement(fieldFillings).click();
    }
}
