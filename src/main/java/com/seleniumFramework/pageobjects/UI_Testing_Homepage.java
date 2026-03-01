package com.seleniumFramework.pageobjects;

import com.seleniumFramework.utils.SeleniumActions;
import com.seleniumFramework.utils.SeleniumAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.seleniumFramework.utils.Browser.getDriver;

public class UI_Testing_Homepage extends SeleniumActions {

    public static final By MENUS = By.xpath("//section[@id='overview']//div[@class='col-sm']//a");

    public static void selectMenu(String menuName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        List<WebElement> elements = getDriver().findElements(MENUS);

        for(WebElement element : elements) {
            if (element.getText().equalsIgnoreCase(menuName)) {
                element = wait.ignoring(StaleElementReferenceException.class)
                                .until(ExpectedConditions.elementToBeClickable(element));
                SeleniumActions.clickElement(element);

                return;
            }
        }

    }
}
