package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReusableMethods {
    public static void waitAndClick(WebDriver driver , WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }
    public static void waitVisibleAndClick(WebDriver driver , WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(webElement)).click();
    }
    public static void goToUrl(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
    public static void waitSecond(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
