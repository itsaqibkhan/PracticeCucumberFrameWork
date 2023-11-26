package com.qa.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStepDef {
    @Given("I'm logged in")
    public void iMLoggedIn() {
        // Write code here that turns the phrase above into concrete actions
    }
    @Then("The product is listed with title {string} and price {string}")
    public void theProductIsListedWithTitleAndPrice(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I click product title {string}")
    public void iClickProductTitle(String string) {
        // Write code here that turns the phrase above into concrete actions
    }
    @Then("I should be on product details page with title {string}, price {string} and description {string}")
    public void iShouldBeOnProductDetailsPageWithTitlePriceAndDescription(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
    }

}
