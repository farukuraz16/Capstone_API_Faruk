package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    private static ThreadLocal< WebDriver> driver=new ThreadLocal<>();

    private Driver() {

    }

    public static WebDriver getDriver() {

        String browser = ConfigReader.getProperty("browser");

        if (driver.get() == null) {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions co = new ChromeOptions();
                    co.addArguments("--remote-allow-origins=*");
                    driver.set(new ChromeDriver(co));
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
            }
            driver.get().manage().window().maximize();
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver.get();
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver = null;
        }
    }
}
