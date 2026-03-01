package com.seleniumFramework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Browser {

    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String EDGE = "edge";

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void waitForPageLoad(WebDriver driver, int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(
                webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    public static WebDriver getDriver() {

        if(driver.get() == null) {
            throw new IllegalStateException("WebDriver has not been initialized. Call setDriver() first.");
        }
        return driver.get();
    }

    public static void navigateTo(String url) {
        getDriver().get(url);
    }

    public void setDriver(String browser) {
        switch (browser.toLowerCase()) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\DevTools\\chromedriver\\chromedriver.exe");

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                driver.set(new ChromeDriver(chromeOptions));
                break;
            case FIREFOX:
                driver.set(new FirefoxDriver());
                break;
            case EDGE:
                driver.set(new EdgeDriver());
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
