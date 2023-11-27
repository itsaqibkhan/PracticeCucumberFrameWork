package com.qa.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

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



    public AppiumDriverLocalService getAppiumService() {
    //    HashMap<String, String> environment = new HashMap<String, String>();
     //   environment.put("PATH", "/home/user/.npm-global/bin:/usr/local/lib/nodejs/node-v18.13.0-linux-x64/bin:/usr/bin:/bin:/usr/sbin:/sbin:/usr/local/bin:/usr/X11/bin:$PATH:/snap/bin:/usr/lib/jvm/jdk-15.0.2/bin:/home/user/Android/Sdk/tools:/home/user/Android/Sdk/platform-tools:/home/user/Android/Sdk/tools/bin" + System.getenv("PATH"));
      //  environment.put("ANDROID_HOME", "/home/user/Android/Sdk");
        GlobalParams params =new GlobalParams();
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("/usr/local/lib/nodejs/node-v18.13.0-linux-x64/bin/node"))
                .withAppiumJS(new File("/usr/local/lib/nodejs/node-v18.13.0-linux-x64/lib/node_modules/appium/build/lib/main.js"))
                .usingPort(4723)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)                            //To override the existing session
         //       .withEnvironment(environment)
                .withLogFile(new File(params.getPlaformName() +"_" + params.getDeviceName() + File.separator + "server.log")) );
    }
}