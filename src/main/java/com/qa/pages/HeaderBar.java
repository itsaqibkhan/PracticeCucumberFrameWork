package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HeaderBar extends BasePage {
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView") private WebElement menuBtn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView") private WebElement cartBtn;

    public MenuBar pressMenuBtn(){
        click(menuBtn);
        return new MenuBar();
    }
    public CartScreen pressCartBtn(){
        click(cartBtn);
        return new CartScreen();
    }

}
