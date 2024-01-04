package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class GlobalParams {

    protected static ThreadLocal <String> udid= new ThreadLocal<String>();
    protected static ThreadLocal <String> deviceName = new ThreadLocal<String>();
    protected static ThreadLocal <String> platformName = new ThreadLocal<String>();
    protected static ThreadLocal <String> automationName = new ThreadLocal<String>();


    public String getUdid(){
        return udid.get();
    }
    public void setUdid(String udid2){
         udid.set(udid2);
    }
    public String getDeviceName() {
        return deviceName.get();
    }
    public void setDeviceName(String deviceName2) {
        deviceName.set(deviceName2);
    }
    public String getPlaformName() {
        return platformName.get();
    }

    public void setPlatform(String platform2) {
        platformName.set(platform2);
    }

    public String getAutomationName() {
        return automationName.get();
    }

    public void setAutomationName(String platform2) {
        automationName.set(platform2);
    }

    PropertyManager propertyManager = new PropertyManager();



    public void initializeGlobalParams() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = propertyManager.getProps();
        params.setPlatform(System.getProperty("platformName", "Android"));
        params.setDeviceName(System.getProperty("deviceName", "Realme 7"));
        params.setUdid(System.getProperty("udid", "L7854L45IJ8X5L5X"));
        params.setAutomationName(props.getProperty("automationName"));

    }

}
