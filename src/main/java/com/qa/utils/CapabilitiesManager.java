package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class CapabilitiesManager {

    TestUtils utils = new TestUtils();
    GlobalParams params = new GlobalParams();


    public DesiredCapabilities getCaps() throws IOException {
    GlobalParams params = new GlobalParams();
        try {
            utils.log().info("Getting capabilities");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", params.getPlaformName() );
            caps.setCapability("appium:deviceName", params.getDeviceName());
            caps.setCapability("appium:udid", params.getUdid());
            caps.setCapability("appium:automationName", params.getAutomationName());
            String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                    File.separator + "resources" + File.separator + "apps" + File.separator +  "Android-MyDemoAppRN.1.3.0.build-244(1).apk";
            utils.log().info("App url is:" + appUrl);
            caps.setCapability("appium:app", appUrl);
            System.out.println(caps);
            return caps;
        } catch(Exception e){
            e.printStackTrace();
            utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
            throw e;
        }

    }

}
