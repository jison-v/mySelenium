package selenium.runner;

import com.selenium.actions.SeleniumActions;
import com.selenium.pageobjects.CHEDPage;
import com.selenium.pageobjects.FacebookLoginPage;
import com.selenium.util.Browser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class BaseTest extends SeleniumActions {

    SeleniumActions actions = new SeleniumActions();
    FacebookLoginPage facebookLoginPage = new FacebookLoginPage();
    CHEDPage chedPage = new CHEDPage();

    @Test(priority = 0)
    public void openFacebookAndLogin(){

        actions.openBrowser("https://www.facebook.com/");
        facebookLoginPage.enterUsername("sample@name.com");
        facebookLoginPage.enterPassword("password");

        facebookLoginPage.clickLogin();
    }

    @Test(priority = 1)
    public void openETEEAPinCHEDPage(){

        actions.openBrowser("https://ched.e.gov.ph/home");
        chedPage.selectMenu("Program and Project");
        chedPage.selectSubMenu("Non-conventional Path to Higher Ed");

        chedPage.verifyETEEAPText();

    }

    @AfterTest
    public void TearDown(){

        Browser.closeDriver();
    }

}
