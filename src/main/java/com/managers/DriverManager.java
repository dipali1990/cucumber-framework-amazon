package com.managers;

import com.util.BrowserToUse;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    public static WebDriver initializeDriver(String browser){
        if(browser.equalsIgnoreCase(BrowserToUse.Chrome.toString())){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("Chrome Driver initialized");
        }else{
            System.out.println("Could not initialize the browser");
            driver = null;
        }

        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        return getDriver();
    }

}
