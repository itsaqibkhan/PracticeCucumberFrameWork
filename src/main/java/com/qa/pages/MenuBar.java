package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MenuBar extends BasePage {
    @AndroidFindBy(accessibility = "menu item log in") private WebElement LoginBtnMenuPage;


    public LoginPage pressLoginBtnMenuPage(){
        click(LoginBtnMenuPage);
        return new LoginPage();

    }

}
