package runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginStep;
import pages.tokenDeneme;
import utilities.Driver;

public class token {


    @Test
    public void test(){
        LoginStep ls = new LoginStep(Driver.getDriver());
        ls.login();


    }

    @Test
    public void test2(){
        tokenDeneme td = new tokenDeneme();
        td.getToken();
    }


}
