package com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public Properties initProperties(){
        Properties prop = new Properties();
        try{
            FileInputStream fip = new FileInputStream("src/test/resources/configs/config.properties");
            prop.load(fip);
        }catch(IOException ioException){
            ioException.printStackTrace();
        }

        return prop;
    }

}
