package selenium.runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.seleniumFramework.utils.Browser;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


@CucumberOptions(
        features = "src/test/resources/features/ui",
        glue = "com.seleniumFramework.stepdefinitions",
        plugin = {"pretty", "html:target/ui-cucumber-html-report.html"},
        tags = "@AutomationPracticeLogin"
)
public class UIRunner extends AbstractTestNGCucumberTests {
    // TestNG runner for Cucumber feature files related to UI testing
    @BeforeTest(alwaysRun = true)
    public void setup() {
        Browser.setDriver("chrome");
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        ExtentReports extentReports = new ExtentReports();
        ExtentTest test = extentReports.createTest("UI Test Report");

        extentReports.flush();
        Browser.quitDriver();
    }
}
