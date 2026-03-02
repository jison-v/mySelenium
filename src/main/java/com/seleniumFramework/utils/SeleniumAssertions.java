package com.seleniumFramework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class SeleniumAssertions extends Browser{

    private static final int DEFAULT_TIMEOUT = 10;
    private static final int LOW_TIMEOUT = 5;
    private static final int HIGH_TIMEOUT = 20;

    private static Logger consoleLogger = LoggerFactory.getLogger(SeleniumAssertions.class);

    public static void assertText(By locator, String actualText) {

        waitForPageLoad(getDriver(), DEFAULT_TIMEOUT);
        WebElement element = getElement(getDriver(), locator, LOW_TIMEOUT);
        element = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));

        String expectedText = element.getText();
        if (!expectedText.equals(actualText)) {
            throw new AssertionError("FAILED: Expected text: '" + expectedText + "' but got: '" + actualText + "'");
        }else{
            consoleLogger.info("PASSED: Text verification successful. Expected and actual text: '{}'", expectedText);
        }
    }

    public static void assertElementEnabled(By locator) {
        waitForPageLoad(getDriver(), DEFAULT_TIMEOUT);
        WebElement element = getElement(getDriver(), locator, LOW_TIMEOUT);
        element = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));

        if (!element.isEnabled()) {
            throw new AssertionError("FAILED: Expected element to be enabled but it is disabled: " + locator);
        }else{
            consoleLogger.info("PASSED: Element is enabled as expected: {}", locator);
        }
    }
}
