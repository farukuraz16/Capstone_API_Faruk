package pages;



import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class LoginStep {

    public WebDriver driver;


    public LoginStep(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginStep() {
    }

    @FindBy(id = "loginButton")
    public WebElement login_button;

    @FindBy(id = "username")
    WebElement login_username;

    @FindBy(id = "password")
    WebElement login_password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement login_onay_btn;

    @FindBy(xpath = "//pre[@style=\"word-wrap: break-word; white-space: pre-wrap;\"]")
    WebElement bodyTokenPage;


    String username = ConfigReader.getProperty("username");
    String password = ConfigReader.getProperty("password");
    String url = ConfigReader.getProperty("url");
    String urlToken = ConfigReader.getProperty("urlToken");
    public static String access_token;


    public void login() {
        driver.get(url);
        login_button.click();
        login_username.sendKeys(username);
        login_password.sendKeys(password);
        login_onay_btn.click();
        driver.get(urlToken);
        String bodyToken = bodyTokenPage.getText();
        System.out.println("bodyToken = " + bodyToken);
        HashMap<String, Object> bodyTokenPageDatas = JsonToJava.convertJsonToJavaObject(bodyToken, HashMap.class);
        System.out.println("bodyTokenPageDatas = " + bodyTokenPageDatas);
        access_token = (String) bodyTokenPageDatas.get("access_token");
        System.out.println("access_token = " + access_token);
        driver.quit();
    }



    public void GET(){
        String URL = "https://a3m-qa-gm3.quaspareparts.com/auth/api/user";
        Response response = given().
                when().
                header("Authorization","Bearer "+access_token).
                get(URL);
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
    }




}
