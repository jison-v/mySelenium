package com.seleniumFramework.pageobjects;

import com.seleniumFramework.utils.Browser;
import com.seleniumFramework.utils.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutomationExercisePage extends SeleniumActions {

    private static final By MENU_OPTIONS = By.xpath("//ul[@class='nav navbar-nav']//li/a");
    private static final String HOME_PAGE_URL = "https://automationexercise.com/";

    public String getHomePageUrl() {
        return HOME_PAGE_URL;
    }

    public static void selectMenuOption(String menuOption) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        waitForPageLoad(getDriver(), 10);

        List<WebElement> elements = getElements(MENU_OPTIONS, 10);

        for(WebElement element: elements) {
            if (element.getText().equalsIgnoreCase(menuOption)) {
                wait.ignoring(StaleElementReferenceException.class)
                .until(driver -> element.isDisplayed() && element.isEnabled());

                SeleniumActions.clickElement(element);
                return;
            }
        }
         throw new RuntimeException("Menu option not found: " + menuOption);
    }
}
