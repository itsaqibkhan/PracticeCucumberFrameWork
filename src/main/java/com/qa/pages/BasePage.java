package com.qa.pages;

import com.qa.utils.DriverManager;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    protected final AppiumDriver driver;
    TestUtils utils = new TestUtils();

    public BasePage(){
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void waitForVisibility(WebElement e)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void click(WebElement e)
    {
        waitForVisibility(e);
        e.click();
    }
    public void sendKeys(WebElement e, String txt){
        waitForVisibility(e);
        e.sendKeys(txt);
    }
    public void clear(WebElement e){
        waitForVisibility(e);
        e.clear();
    }
    public String getAttribute(WebElement e, String attribute){
       waitForVisibility(e);
      return e.getAttribute(attribute);
    }

    public void terminateApp(){
        ((InteractsWithApps) driver).terminateApp(driver.getCapabilities().
                getCapability("appPackage").toString());

    }
    public void activateApp(){
        ((InteractsWithApps) driver).activateApp(driver.getCapabilities().
                getCapability("appPackage").toString());

    }

    public void pressBackButton(){
       // ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
       // ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
        driver.navigate().back();
   }

}
