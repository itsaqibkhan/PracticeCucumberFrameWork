package com.qa.stepdef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {


    @When("I login")
    public void iLogin() {
        // Write code here that turns the phrase above into concrete actions
     }
    @Then("Login should fail with error message as {string}")
    public void loginShouldFailWithErrorMessageAs(String string) {
        // Write code here that turns the phrase above into concrete actions
     }

    @When("I enter username as {string}")
    public void iEnterUsernameAs(String string) {
        // Write code here that turns the phrase above into concrete actions
     }
    @When("I enter password as {string}")
    public void iEnterPasswordAs(String string) {
        // Write code here that turns the phrase above into concrete actions
     }

    @Then("Login successful and redirect to product page with {string}")
    public void loginSuccessfulAndRedirectToProductPageWith(String string) {
        // Write code here that turns the phrase above into concrete actions
     }

}
