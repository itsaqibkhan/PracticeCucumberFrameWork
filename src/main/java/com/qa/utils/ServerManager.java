package com.qa.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.logging.log4j.ThreadContext;

import java.io.File;
import java.util.HashMap;

public class ServerManager {
    private static final ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
    TestUtils utils = new TestUtils();

    public AppiumDriverLocalService getServer(){
        return server.get();
    }

    public void startServer(){
       utils.log().info("starting appium server");
        AppiumDriverLocalService server = getAppiumService();
        //  AppiumDriverLocalService server = WindowsGetAppiumService();
        server.start();
        if(server == null || !server.isRunning()){
           utils.log().fatal("Appium server not started. ABORT!!!");
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!!!");
        }
        server.clearOutPutStreams();
        this.server.set(server);
        utils.log().info("Appium server started");
    }

    public AppiumDriverLocalService getAppiumServerDefault() {
        return AppiumDriverLocalService.buildDefaultService();
    }

//    public AppiumDriverLocalService getAppiumService() {    For appventurez linux machine
//
//        HashMap<String, String> environment = new HashMap<String, String>();
//        environment.put("PATH", "/home/user/.npm-global/bin:/usr/local/lib/nodejs/node-v18.13.0-linux-x64/bin:/usr/bin:/bin:/usr/sbin:/sbin:/usr/local/bin:/usr/X11/bin:$PATH:/snap/bin:/usr/lib/jvm/jdk-15.0.2/bin:/home/user/Android/Sdk/tools:/home/user/Android/Sdk/platform-tools:/home/user/Android/Sdk/tools/bin" + System.getenv("PATH"));   //echo $PATH  to get this path
//        environment.put("ANDROID_HOME", "/home/user/Android/Sdk");
//        GlobalParams params =new GlobalParams();
//        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//                .usingDriverExecutable(new File("/usr/local/lib/nodejs/node-v18.13.0-linux-x64/bin/node"))
//                .withAppiumJS(new File("/usr/local/lib/nodejs/node-v18.13.0-linux-x64/lib/node_modules/appium/build/lib/main.js"))
//                .usingAnyFreePort()
//                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)                            //To override the existing session
//                .withEnvironment(environment)                                                // Because the system environment variable is not exposed to java
//                .withLogFile(new File(params.getPlaformName() +"_" + params.getDeviceName() + File.separator + "server.log")));                           // To output the log in this file
//    }



    public AppiumDriverLocalService getAppiumService() {
        HashMap<String, String> environment = new HashMap<String, String>();
        environment.put("PATH", "C:\\WINDOWS\\system32;C:\\WINDOWS;C:\\WINDOWS\\System32\\Wbem;C:\\WINDOWS\\System32\\WindowsPowerShell\\v1.0\\;C:\\WINDOWS\\System32\\OpenSSH\\;C:\\Program Files\\dotnet\\;C:\\Users\\mohd.aqib\\Downloads\\apache-maven-3.9.6-bin\\apache-maven-3.9.6\\bin;C:\\Program Files\\Java\\jdk-21.0.2\\bin;C:\\Program Files\\Git\\cmd;C:\\Program Files\\Java\\jdk-21.0.2\\bin;C:\\Program Files\\PowerShell\\7\\;C:\\Users\\mohd.aqib\\AppData\\Local\\Android\\Sdk\\platform-tools;C:\\Users\\mohd.aqib\\AppData\\Local\\Android\\Sdk\\cmdline-tools;C:\\Program Files\\nodejs\\;C:\\Program Files\\MySQL\\MySQL Shell 8.0\\bin\\;C:\\Users\\mohd.aqib\\AppData\\Local\\Microsoft\\WindowsApps;C:\\Users\\mohd.aqib\\RESTTestNGFramework\\allure-2.32.2\\bin;C:\\Users\\mohd.aqib\\AppData\\Roaming\\npm" + System.getenv("PATH"));   //echo %PATH%  to get this path
        environment.put("ANDROID_HOME", "C:\\Users\\mohd.aqib\\AppData\\Local\\Android\\Sdk");
        GlobalParams params =new GlobalParams();
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                .withAppiumJS(new File("C:\\Users\\mohd.aqib\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))      //Default appium installation path
                .usingPort(4723)                                                              // .usingAnyFreePort()  Can be also used
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)                            //To override the existing session
                .withEnvironment(environment));                                            // Because the system environment variable is not exposed to java
//                .withLogFile(new File(params.getPlaformName() +"_" + params.getDeviceName() + File.separator + "server.log")));                           // To output the log in this file
    }
}