package selenium.runner;

import com.seleniumFramework.pageobjects.CHEDPage;
import com.seleniumFramework.pageobjects.AutomationExercisePage;
import com.seleniumFramework.pageobjects.VerifyText_Page;
import com.seleniumFramework.utils.Browser;
import com.seleniumFramework.utils.SeleniumAssertions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.seleniumFramework.pageobjects.UI_Testing_Homepage.selectMenu;

public class BaseTest extends Browser {

    @BeforeTest(alwaysRun = true)
    public void initializeDriver() {
        setDriver("chrome");
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        quitDriver();
    }

    AutomationExercisePage facebookLoginPage = new AutomationExercisePage();
    CHEDPage chedPage = new CHEDPage();

    @Test(priority = 0)
    public void openAutomationExercisePage() throws InterruptedException {

        navigateTo(TestData.AUTOMATION_EXERCISES_BASE_URL);

        selectMenu(TestData.MenuOption.CART.getDisplayName());
    }

    @Test(priority = 1)
    public void openETEEAPinCHEDPage() throws InterruptedException {

        navigateTo("https://ched.e.gov.ph/home");
        chedPage.selectMenu("Program and Project");
        chedPage.selectSubMenu("Non-conventional Path to Higher Ed");

        chedPage.verifyETEEAPText();

    }

    @Test
    public void openUITestingPage() throws InterruptedException {
        //Open url
        navigateTo(TestData.UI_TESTING_BASE_URL);
        waitForPageLoad(getDriver(), 10);

        //Select any overview menu
        selectMenu(TestData.TestScenario.VERIFY_TEXT.getDisplayName());

        //Verify the Header
        SeleniumAssertions.assertText(VerifyText_Page.HEADER,TestData.TestScenario.VERIFY_TEXT.getDisplayName());
    }

}
