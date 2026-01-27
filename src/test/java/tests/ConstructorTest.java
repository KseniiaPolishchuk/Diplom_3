package tests;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import browser.DriverHelper;
import pageobject.LocatorsPage;
import pageobject.MainPage;

import java.io.IOException;

public class ConstructorTest {
    DriverHelper driverHelper = new DriverHelper();
    @Test
    public void transitionSections() throws IOException{
        WebDriver driver = driverHelper.initDriver();
        LocatorsPage locatorsPage = new LocatorsPage(driver);
        MainPage mainPage = new MainPage(driver);

        //Проверяем переходы в разделы "Соусы", "Начинки", "Булки"
        locatorsPage.openMainPage();
        mainPage.clickFieldSauces();
        mainPage.clickFieldFillings();
        mainPage.clickFieldBun();
    }
}
