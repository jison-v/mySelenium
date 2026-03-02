package com.seleniumFramework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class SeleniumActions extends Browser{

    private static Logger consoleLogger = LoggerFactory.getLogger(SeleniumActions.class);

    private static final int DEFAULT_TIMEOUT = 10;
    private static final int LOW_TIMEOUT = 5;
    private static final int HIGH_TIMEOUT = 20;


    public static void setText(By locator, String text) {
        waitForPageLoad(getDriver(), DEFAULT_TIMEOUT);
        WebElement element = getElement(getDriver(), locator, DEFAULT_TIMEOUT);
        try {
            element = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
            consoleLogger.info("PASSED: Entered text '{}' into element: {}", text, locator.toString());
        } catch (Exception e) {
            throw new RuntimeException("FAILED: Failed to enter text into element: " + locator.toString());
        }
    }

    public static void clickElement(By locator) {

        waitForPageLoad(getDriver(), DEFAULT_TIMEOUT);
        WebElement element = getElement(getDriver(), locator, DEFAULT_TIMEOUT);

        try {
            int maxTries = 3;
            while (!element.isDisplayed() && maxTries > 0) {
                Thread.sleep(1000);
                maxTries--;
            }
            element = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(element));
            String message = "Clicked element: " + locator.toString();
            element.click();
            consoleLogger.info("PASSED: {}", message);
        } catch (Exception e) {
            throw new RuntimeException("FAILED: Element not found or not clickable: " + locator);
        }
    }

    public static void clickElement(WebElement element) {

        waitForPageLoad(getDriver(), DEFAULT_TIMEOUT);
        element = getElement(getDriver(), element, DEFAULT_TIMEOUT);

        try {
            int maxTries = 3;
            while (!element.isDisplayed() && maxTries > 0) {
                Thread.sleep(1000);
                maxTries--;
            }
            element = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(element));
            String message = "Clicked element: " + element.toString();
            element.click();
            consoleLogger.info("PASSED: {}", message);
        } catch (Exception e) {
            throw new RuntimeException("FAILED: Element not found or not clickable: " + element.toString());
        }
    }

    public static void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static String getElementText(WebElement element) {
        return element.getText();
    }
}
