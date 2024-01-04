package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductDetail extends BasePage {
   @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView") private WebElement productTitle;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"product price\"]") private WebElement productPrice;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Add To Cart button\"]/android.widget.TextView") private WebElement addToCartBtn;

    public String productTitleDetailPage(){
       return getAttribute(productTitle, "text");
    }

    public ProductDetail pressAddToCartBnt() {
        click(addToCartBtn);
        return this;
    }








}
