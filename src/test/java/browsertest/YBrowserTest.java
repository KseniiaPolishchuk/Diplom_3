package browsertest;
import org.junit.Test;

public class YBrowserTest extends browsertest.BaseTest {
    @Test
    public void startBrowserTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://ya.ru/");
        Thread.sleep(3000);

    }
}
