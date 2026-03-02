package com.seleniumFramework.stepdefinitions;

import com.seleniumFramework.pageobjects.AutomationExercisePage;
import com.seleniumFramework.utils.Browser;
import com.seleniumFramework.utils.SeleniumActions;
import io.cucumber.java.en.Given;

public class AutomationPracticeStepDefinition extends SeleniumActions {

    AutomationExercisePage automationExercisePage = new AutomationExercisePage();

    @Given("user open the automation practice website {string}")
    public void userOpenAutomationPractice(String url) {

        Browser.navigateTo(url);

    }
}
