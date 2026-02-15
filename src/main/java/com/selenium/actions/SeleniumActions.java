package com.selenium.actions;

import com.selenium.util.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import java.time.Duration;

public class SeleniumActions {

    private static final Logger log = LogManager.getLogger(SeleniumActions.class);

    public WebElement element(By locator){

        return new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void openBrowser(String url){

        log.info("Open URL");
        Browser.getDriver().get(url);

    }

    public void ClickElement(By locator){

        Reporter.log("Click the element");
        element(locator).click();
        Assert.assertTrue(true, "Element is successfully clicked.");
    }

    public void SetText(By locator, String input) {

        Reporter.log("Input text.");
        element(locator).sendKeys(input);
        Assert.assertTrue(true, "Text is successfully added.");
    }

    public void SelectDropdownbyValue(By locator, String value){

        Select select = new Select(element(locator));
        select.deselectByValue(value);
        Assert.assertTrue(true, "Dropdown option is successfully added.");

    }

    public void SelectDropdownbyIndex(By locator, int index){

        Select select = new Select(element(locator));
        select.selectByIndex(index);
        Assert.assertTrue(true, "Dropdown option is successfully added.");

    }
}
