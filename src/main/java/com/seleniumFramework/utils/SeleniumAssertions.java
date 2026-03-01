package com.seleniumFramework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.seleniumFramework.utils.Browser.getDriver;

public class SeleniumAssertions {

    public static void verifyText(By locator, String expectedText) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try{
            String actualText = element.getText();
            if (!actualText.equals(expectedText)) {
                throw new AssertionError("Expected text: " + expectedText + ", but got: " + actualText);
            }else{
                System.out.println("Text verification passed: " + actualText);
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Element not found or not visible: " + locator);
        }
    }

    public static void verifyEnabled(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try{
            if (!element.isEnabled()) {
                throw new AssertionError("Expected element to be enabled, but it is disabled: " + locator);
            }else{
                System.out.println("Element is enabled as expected: " + locator);
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Element not found or not visible: " + locator);
        }
    }
}
