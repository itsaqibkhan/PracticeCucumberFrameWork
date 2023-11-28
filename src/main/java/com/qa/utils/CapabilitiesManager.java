package com.qa.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class CapabilitiesManager {

    TestUtils utils = new TestUtils();

    public DesiredCapabilities getProps() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        try {
            utils.log().info("Getting capabilities");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", params.getPlaformName() );
            caps.setCapability("deviceName", params.getDeviceName());
            caps.setCapability("udid", params.getUdid());
            caps.setCapability("automationName", params.getAutomationName());
            String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                    File.separator + "resources" + File.separator + "app" + File.separator +  "Android-MyDemoAppRN.1.3.0.build-244(1).apk";
            utils.log().info("App url is:" + appUrl);
            caps.setCapability("app", "appUrl");
            return caps;
        } catch(Exception e){
            e.printStackTrace();
            utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
            throw e;
        }

    }

}
