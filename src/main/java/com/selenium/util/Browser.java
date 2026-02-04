package com.selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    private static WebDriver driver = new ChromeDriver();

    public static WebDriver getDriver() {

        System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\DevTools\\chromedriver\\chromedriver.exe");

        driver.manage().window().maximize();

        return driver;
    }

    public static void closeDriver(){

        if(driver != null) driver.quit();
    }
}
