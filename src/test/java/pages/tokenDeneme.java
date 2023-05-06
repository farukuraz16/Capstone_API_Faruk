package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ConfigReader;

public class tokenDeneme {

    String username = ConfigReader.getProperty("username");
    String password = ConfigReader.getProperty("password");


    public void getToken(){
         WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions().setHeadless(true);
        opt.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(opt);
        driver.get("https://qa-gm3.quaspareparts.com/oauth2/authorization/a3m-client");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.tagName("button")).click();
        driver.navigate().to("https://qa-gm3.quaspareparts.com/auth/userinfo");
        JsonPath path = new JsonPath(driver.findElement(By.tagName("body")).getText());
        String token = path.getString("access_token");
        System.out.println("Token: " + token);
        driver.quit();
    }
}
