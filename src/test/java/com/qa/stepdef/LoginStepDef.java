package com.qa.stepdef;

import com.qa.pages.HomeScreen;
import com.qa.pages.LoginPage;
import com.qa.pages.MenuBar;
import com.qa.pages.ProductDetail;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {


    @When("I login")
    public void iLogin() {
        new LoginPage().pressLoginBtn();
     }
    @Then("Login should fail with error message as {string}")
    public void loginShouldFailWithErrorMessageAs(String err) {
        Assert.assertEquals(new LoginPage().getMainErrTxt(), err);
     }

    @When("I enter username as {string}")
    public void iEnterUsernameAs(String username) {
            new LoginPage().enterUserName(username);
     }
    @When("I enter password as {string}")
    public void iEnterPasswordAs(String password) {
        new LoginPage().enterPassword(password);
     }

    @Then("Login successful and redirect to product page with {string}")
    public void loginSuccessfulAndRedirectToProductPageWith(String title) {
        Assert.assertEquals(new HomeScreen().getTitle(), title);
     }

    @When("I tap on menu button")
    public void iTapOnMenuButton() {
        new HomeScreen().pressMenuBtn();
    }

    @And("I tap on login button")
    public void iTapOnLoginButton() {
        new MenuBar().pressLoginBtnMenuPage();
    }

    @Then("Login not completed with error message as {string}")
    public void loginNotCompletedWithErrorMessageAs(String err) {
            Assert.assertEquals(new LoginPage().getErrTxt(), err);
    }

}
