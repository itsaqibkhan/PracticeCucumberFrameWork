package com.qa.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

    private static Properties props = new Properties();
    TestUtils utils = new TestUtils();

    public  Properties getProps() throws IOException {
        InputStream is = null;
        String propsFileName = "config.properties" ;
        if (props.isEmpty())
        {
            try {
//                utils.log().info("Loading config properties");   Need to comment as we are loggin before setting ThreadContext
                is = getClass().getClassLoader().getResourceAsStream(propsFileName);
                props.load(is);
            } catch(IOException e) {
                e.printStackTrace();
                utils.log().fatal("Failed to load config properties, Abort!!" + e.toString());
                throw e;
            }finally {
                if(is !=null)
                 is.close();
            }
        }
        return props;
    }
}
