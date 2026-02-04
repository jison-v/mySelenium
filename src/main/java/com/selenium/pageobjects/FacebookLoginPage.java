package com.selenium.pageobjects;

import com.selenium.actions.SeleniumActions;
import org.openqa.selenium.By;

public class FacebookLoginPage {

    private static final By EMAIL_INPUT = By.xpath("//input[@id='email']");
    private static final By PASSWORD_INPUT = By.xpath("//input[@id='pass']");
    private static final By LOGIN_BUTTON = By.xpath("//button[@name='login']");

    SeleniumActions seleniumActions = new SeleniumActions();

    public void enterUsername(String username){

        seleniumActions.SetText(EMAIL_INPUT, username);
    }

    public void enterPassword(String password){

        seleniumActions.SetText(PASSWORD_INPUT, password);
    }

    public void clickLogin() {

        seleniumActions.ClickElement(LOGIN_BUTTON);
    }
}
