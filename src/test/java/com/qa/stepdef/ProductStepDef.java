package com.qa.stepdef;

import com.qa.pages.HomeScreen;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductDetail;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductStepDef {
    @Given("I'm logged in")
    public void iMLoggedIn() {
       new LoginPage().login("bob@example.com", "10203040");
    }
    @Then("The product is listed with title {string}")
    public void theProductIsListedWithTitleAndPrice(String string) {
        Assert.assertEquals(new HomeScreen().getSLBName(), string);
    }

    @When("I click product title {string}")
    public void iClickProductTitle(String string) {
        new HomeScreen().pressSLBName();
    }
    @Then("I should be on product details page with title {string}, price {string} and description {string}")
    public void iShouldBeOnProductDetailsPageWithTitlePriceAndDescription(String title, String price, String description) throws InterruptedException {
        Thread.sleep(3000);
         Assert.assertEquals(new ProductDetail().productTitleDetailPage(), title);
    }

}
