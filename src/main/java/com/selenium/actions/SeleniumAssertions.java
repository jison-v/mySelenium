package com.selenium.actions;

import com.selenium.util.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumAssertions {

    public WebElement element(By locator){

        return new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean verifyText(By locator, String expectedText){

        if (element(locator).getText().equals(expectedText)){
            return true;
        }else return false;
    }

    public boolean verifyEnabled(By locator){

        if (element(locator).isEnabled()){
            return true;
        } else return false;

    }

    public boolean verifyValue(By locator, String value){

        if(element(locator).getAttribute("value").equals(value)){
            return true;
        }else return false;
    }
}
