package com.seleniumFramework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import java.time.Duration;

public class SeleniumActions extends Browser {

    private static final int DEFAULT_TIMEOUT = 10;
    private static Logger consoleLogger = LoggerFactory.getLogger(SeleniumActions.class);

    public static void setFrame(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
        waitForPageLoad(getDriver(), DEFAULT_TIMEOUT);

        WebElement frameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            getDriver().switchTo().frame(frameElement);
            String message = "Switched to frame: " + locator;
            Reporter.log(message, true);
            consoleLogger.info(message);
        } catch (Exception e) {
            String errorMsg = "Frame not found or not visible: " + locator;
            consoleLogger.error(errorMsg, e);
            throw new RuntimeException(errorMsg);
        }
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
        waitForPageLoad(getDriver(), DEFAULT_TIMEOUT);

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        try {
            int maxTries = 3;
            while (!element.isDisplayed() && maxTries > 0) {
                Thread.sleep(1000);
                maxTries--;
            }
            wait.ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            Reporter.log("Clicked element: " + locator, true);
            consoleLogger.info("Clicked element: " + locator);
        } catch (Exception e) {
            throw new RuntimeException("Element not found or not clickable: " + locator);
        }
    }

    public static void clickElement(WebElement element) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
        waitForPageLoad(getDriver(), DEFAULT_TIMEOUT);

        try {
            int maxTries = 3;
            while (!element.isDisplayed() && maxTries > 0) {
                Thread.sleep(1000);
                maxTries--;
            }
            wait.ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(element));
            String message = "Clicked element: " + element.getText();
            element.click();
            Reporter.log(message, true);
            consoleLogger.info(message);
        } catch (Exception e) {
            throw new RuntimeException("Element not found or not clickable: " + element);
        }
    }

    public static void setText(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
        waitForPageLoad(getDriver(), DEFAULT_TIMEOUT);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            element.clear();
            element.sendKeys(text);
            Reporter.log("Set text '" + text + "' in element: " + locator, true);
            consoleLogger.info("Set text '" + text + "' in element: " + locator);
        } catch (Exception e) {
            throw new RuntimeException("Element not found or not interactable: " + locator);
        }
    }

    public static void selectDropdownByVisibleText(By locator, String visibleText) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
        waitForPageLoad(getDriver(), DEFAULT_TIMEOUT);

        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            Select select = new Select(dropdown);
            select.selectByVisibleText(visibleText);
            String message = "Selected dropdown option by visible text '" + visibleText + "' from: " + locator;
            Reporter.log(message, true);
            consoleLogger.info(message);
        } catch (Exception e) {
            String errorMsg = "Dropdown not found or option not available: " + locator;
            consoleLogger.error(errorMsg, e);
            throw new RuntimeException(errorMsg);
        }
    }

    public static void selectDropdownByValue(By locator, String value) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
        waitForPageLoad(getDriver(), DEFAULT_TIMEOUT);

        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            Select select = new Select(dropdown);
            select.selectByValue(value);
            String message = "Selected dropdown option by value '" + value + "' from: " + locator;
            Reporter.log(message, true);
            consoleLogger.info(message);
        } catch (Exception e) {
            String errorMsg = "Dropdown not found or option not available: " + locator;
            consoleLogger.error(errorMsg, e);
            throw new RuntimeException(errorMsg);
        }
    }

    public static void selectDropdownByIndex(By locator, int index) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
        waitForPageLoad(getDriver(), DEFAULT_TIMEOUT);

        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            Select select = new Select(dropdown);
            select.selectByIndex(index);
            String message = "Selected dropdown option by index '" + index + "' from: " + locator;
            Reporter.log(message, true);
            consoleLogger.info(message);
        } catch (Exception e) {
            String errorMsg = "Dropdown not found or option not available: " + locator;
            consoleLogger.error(errorMsg, e);
            throw new RuntimeException(errorMsg);
        }
    }

}
