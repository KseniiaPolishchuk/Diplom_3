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
    @Step("Нажатие на кнопку 'Войти в аккаунт'")
    public void clickButtonEntranceManePage() {
        driver.findElement(buttonEntranceManePage).click();
    }
    @Step("Нажатие на кнопку личного кабинета")
    public void clickButtonEntrancePersonalAccount() {
        driver.findElement(buttonEntrancePersonalAccount).click();
    }
    @Step("Нажатие на раздел 'Булки'")
    public void clickFieldBun() {
        driver.findElement(fieldBun).click();
    }
    @Step("Нажатие на раздел 'Соусы'")
    public void clickFieldSauces() {
       driver.findElement(fieldSauces).click();
    }
    @Step("Получение текста раздела 'Соусы' и сравнение его с ожидаемым текстом")
    public void getTextSectionSauces(){
        driver.findElement(fieldSauces).getText();
        assertEquals("Соусы", fieldSauces);
    }

    private void assertEquals(String соусы, By fieldSauces) {
    }
    @Step("Получение текста раздела 'Начинки' и сравнение его с ожидаемым текстом")
    public void getTextSectionFillings(){
        driver.findElement(fieldFillings).getText();
        assertEquals("Начинки", fieldFillings);
    }
    @Step("Получение текста раздела 'Булки' и сравнение его с ожидаемым текстом")
    public void getTextSectionBun(){
        driver.findElement(fieldBun).getText();
        assertEquals("Булки", fieldBun);
    }
    @Step("Нажатие на раздел 'Начинки'")
    public void clickFieldFillings() {
        driver.findElement(fieldFillings).click();
    }
}
