package com.seleniumFramework.pageobjects;

import com.seleniumFramework.utils.SeleniumActions;
import com.seleniumFramework.utils.SeleniumAssertions;
import org.openqa.selenium.By;

public class CHEDPage extends SeleniumActions{

    SeleniumAssertions seleniumAssertions = new SeleniumAssertions();

    private static final By HOME_MENU = By.xpath("//a[text()='HOME']");
    private static final By ABOUT_US_MENU = By.xpath("//button/span[text()='ABOUT US']");
    private static final By PROGRAM_AND_PROJECT_MENU = By.xpath("//button/span[text()='PROGRAMS & PROJECTS']");
    private static final By NONCONVENTIONAL_SUBMENU = By.xpath("//div/a[text()='Non-Conventional Pathways to Higher Ed']");
    private static final By ETEEAP_TAB = By.xpath("//div[@class='container mx-auto']/div/button[1]/span[1]");

    public void verifyETEEAPText() {

        seleniumAssertions.assertText (ETEEAP_TAB, "ETEEAP");
    }

    public void selectMenu(String menu) throws InterruptedException {

        switch (menu) {

            case "Home":
                clickElement(HOME_MENU);
                break;
            case "About":
                clickElement(ABOUT_US_MENU);
                break;
            case "Program and Project":
                clickElement(PROGRAM_AND_PROJECT_MENU);
                break;
            default:
                break;
        }
    }

    public void selectSubMenu(String subMenu) throws InterruptedException {

        switch (subMenu) {
            case "Non-conventional Path to Higher Ed":
                clickElement(NONCONVENTIONAL_SUBMENU);
        }
    }
}
