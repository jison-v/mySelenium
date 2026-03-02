package com.seleniumFramework.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class Browser {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final String DRIVER_PATH = "C:\\Workspace\\DevTools\\chromedriver\\";

    //Refresh the current page using the WebDriver's navigate().refresh() method
    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    //Waits for the presence of all elements located by the specified locator using FluentWait
    public static List<WebElement> getElements(By locator, int timeoutInSeconds) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(getDriver())
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);

        List <WebElement> element;
        try {
            element = fluentWait.withTimeout(Duration.ofSeconds(timeoutInSeconds))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            throw new RuntimeException("Elements not found: " + locator, e);
        }
        return element;
    }

    //Waits for the specified element to be visible and enabled before returning it
    public static WebElement getElement(WebDriver driver, By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(webDriver -> {
                    WebElement element = webDriver.findElement(locator);
                    return (element.isDisplayed() && element.isEnabled()) ? element : null;
                });
    }

    public static WebElement getElement(WebDriver driver, WebElement element, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(webDriver -> element.isDisplayed() && element.isEnabled() ? element : null);
    }

    //Waits for the page to load completely by checking the document.readyState property
    public static void waitForPageLoad(WebDriver driver, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    //Closes the WebDriver instance for the current thread and removes it from the ThreadLocal storage
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    //Navigate to the specified URL using the current WebDriver instance
    public static void navigateTo(String url) {
        getDriver().get(url);
    }

    //Get the current WebDriver instance for the current thread
    public static WebDriver getDriver() {
        if(driver != null) {
            return driver.get();
        } else {
            throw new IllegalStateException("WebDriver has not been initialized. Call setDriver() first.");
        }
    }

    //Set the WebDriver based on the specified browser type
    public static void setDriver(String browser) {

        switch (browser.toLowerCase()) {
            case "chrome":
                // Code to initialize ChromeDriver
                System.setProperty("webdriver.chrome.driver", DRIVER_PATH + "chromedriver.exe");

                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("--disable-notifications");

                driver.set(new ChromeDriver(options));
                break;
            case "firefox":
                // Code to initialize FirefoxDriver
                System.setProperty("webdriver.gecko.driver", DRIVER_PATH + "geckodriver.exe");

                driver.set(new FirefoxDriver());
                break;
            case "edge":
                // Code to initialize EdgeDriver
                System.setProperty("webdriver.edge.driver", DRIVER_PATH + "msedgedriver.exe");

                driver.set(new EdgeDriver());
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

    }

}
