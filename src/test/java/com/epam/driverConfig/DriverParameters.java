package com.epam.driverConfig;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverParameters {
    public String webdriver = "webdriver";
    public String delay = "delay";
    public String driverPath = "driverpath";
    public String result = "";
    public InputStream inputStream;

    public String getProp(String driver1) throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "parameters.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
            String driverpath = prop.getProperty(driver1);
            result = driverpath;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }

}
