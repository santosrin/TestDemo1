package example;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridTest1 {
    WebDriver driver;
    @Test
     public void setup() throws MalformedURLException {

        //Desired capabilities  - set up the Platform, Browser and Browser Version
        DesiredCapabilities ds = new DesiredCapabilities();
        ds.setBrowserName("chrome");
        ds.setPlatform(Platform.MAC);

        //ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.merge(ds);

        //Set the HUB Url and RemoteWebDriver
        String hubUrl = "http://192.168.1.148:4444/wd/hub";
        driver = new RemoteWebDriver(new URL(hubUrl),options);
    }

    @Test
    public void testN() {
        driver.get("http://www.freecrm.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    }


