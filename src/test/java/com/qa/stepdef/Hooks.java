package com.qa.stepdef;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.ThreadContext;

public class Hooks {

    @Before                                //Will run before every cucumber scenario
    public void initialize() throws Exception {
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();
        ThreadContext.put("ROUTINGKEY", params.getPlaformName() + "_" + params.getDeviceName());

        new ServerManager().startServer();
        new DriverManager().initializeDriver();
    }

    @After                                 //Will run after every cucumber scenario
    public void quit(){
        DriverManager driverManager = new DriverManager();
        if(driverManager.getDriver() !=null)
        {
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
        ServerManager serverManager = new ServerManager();
        if (!(serverManager.getServer() ==null)){
            serverManager.getServer().stop();
        }

    }
}
