package hooks;

import com.managers.DriverManager;
import com.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class SetupHooks {
    private Properties prop;
    private WebDriver driver;

    @Before(order=0)
    public void getProperty(){
        ConfigReader configReader = new ConfigReader();
        prop = configReader.initProperties();
    }

    @Before(order=1)
    public void launchBrowser(){
        String browser = prop.getProperty("browser");
        DriverManager driverManager = new DriverManager();
        driver = driverManager.initializeDriver(browser);
    }

    @Before(order = 2)
    public void loadUrl(){
        String url = prop.getProperty("url");
        driver.get(url);
    }

    @After(order=0)
    public void quitBrowser(){
        driver.quit();
    }

    @After(order=1)
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ","_");
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            byte[] sourcePath = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);

        }
    }
}
