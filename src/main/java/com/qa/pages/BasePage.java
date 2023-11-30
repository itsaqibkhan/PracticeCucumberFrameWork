package com.qa.pages;

import com.qa.utils.DriverManager;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class BasePage {

    private final AppiumDriver driver;
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
