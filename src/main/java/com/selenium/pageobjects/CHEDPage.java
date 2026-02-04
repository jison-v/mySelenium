package com.selenium.pageobjects;

import com.selenium.actions.SeleniumActions;
import com.selenium.actions.SeleniumAssertions;
import org.openqa.selenium.By;

public class CHEDPage {

    SeleniumActions seleniumActions = new SeleniumActions();
    SeleniumAssertions assertions = new SeleniumAssertions();

    private static final By HOME_MENU = By.xpath("//a[text()='HOME']");
    private static final By ABOUT_US_MENU = By.xpath("//button/span[text()='ABOUT US']");
    private static final By PROGRAM_AND_PROJECT_MENU = By.xpath("//button/span[text()='PROGRAMS & PROJECTS']");
    private static final By NONCONVENTIONAL_SUBMENU = By.xpath("//div/a[text()='Non-Conventional Pathways to Higher Ed']");
    private static final By ETEEAP_TAB = By.xpath("//div[@class='container mx-auto']/div/button[1]/span[1]");

    public void verifyETEEAPText() {

        assertions.verifyText(ETEEAP_TAB, "ETEEAP");
    }

    public void selectMenu(String menu) {

        switch (menu) {

            case "Home":
                seleniumActions.ClickElement(HOME_MENU);
                break;
            case "About":
                seleniumActions.ClickElement(ABOUT_US_MENU);
                break;
            case "Program and Project":
                seleniumActions.ClickElement(PROGRAM_AND_PROJECT_MENU);
                break;
            default:
                break;
        }
    }

    public void selectSubMenu(String subMenu){

        switch (subMenu) {
            case "Non-conventional Path to Higher Ed":
                seleniumActions.ClickElement(NONCONVENTIONAL_SUBMENU);
        }
    }
}
