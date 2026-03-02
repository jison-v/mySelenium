package com.seleniumFramework.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class SimpleSteps {

    private String value;

    @Given("a system available for testing")
    public void a_system_available_for_testing() {
        // no-op: system precondition
        value = "";
    }

    @When("I perform a trivial action")
    public void i_perform_a_trivial_action() {
        // simple deterministic action
        value = "hello";
    }

    @Then("I should see the expected result")
    public void i_should_see_the_expected_result() {
        Assert.assertEquals(value, "hello", "expected value after trivial action");
    }
}

