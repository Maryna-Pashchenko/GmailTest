package selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Maryna on 05.04.2017.
 */
public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver.set(new ChromeDriver());
            driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
        return driver.get();
    }

    public static void getUrl(String URL) {
        driver.get().get(URL);
    }

    public static void tearDown() {
        if(driver.get()!=null) {
            driver.get().close();
            driver.get().quit();
        }
    }
}
