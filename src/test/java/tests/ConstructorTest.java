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

import java.io.IOException;

public class ConstructorTest {
    private static WebDriver driver;
    @Before
    public void beforeAll() throws IOException{
        DriverHelper driverHelper = new DriverHelper();
        driver = driverHelper.initDriver();
    }

    @Test
    @DisplayName("Раздел 'Соусы'")
    @Description("Проверяем переход в раздел 'Соусы'")
    public void testTransitionSectionsSauces(){
        LocatorsPage locatorsPage = new LocatorsPage(driver);
        MainPage mainPage = new MainPage(driver);

        locatorsPage.openMainPage();
        mainPage.clickFieldSauces();
        mainPage.getTextSectionSauces(); //Завершающий шаг с ассертом
    }
    @Test
    @DisplayName("Раздел 'Начинки'")
    @Description("Проверяем переход в раздел 'Начинки'")
    public void testTransitionSectionsFillings(){
        LocatorsPage locatorsPage = new LocatorsPage(driver);
        MainPage mainPage = new MainPage(driver);

        locatorsPage.openMainPage();
        mainPage.clickFieldFillings();
        mainPage.getTextSectionFillings(); // Завершающий шаг с ассертом
    }
    @Test
    @DisplayName("Раздел 'Булки'")
    @Description("Проверяем переход в раздел 'Булки'")
    public void testTransitionSectionsBun(){
        LocatorsPage locatorsPage = new LocatorsPage(driver);
        MainPage mainPage = new MainPage(driver);

        locatorsPage.openMainPage();
        mainPage.clickFieldFillings();
        mainPage.clickFieldBun();
        mainPage.getTextSectionBun(); // Завершающий шаг с ассертом
    }
    @After
    public void afterCode(){
        driver.quit();
    }
}
