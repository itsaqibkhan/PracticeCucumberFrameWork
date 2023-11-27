package com.qa.stepdef;

import com.qa.utils.GlobalParams;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.ThreadContext;

public class Hooks {

    @Before                                //Will run before every cucumber scenario
    public void initialize(){
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();
        ThreadContext.put("ROUTINGKEY", params.getPlaformName() + "_" + params.getDeviceName());
    }

    @After                                 //Will run after every cucumber scenario
    public void quit(){

    }
}
