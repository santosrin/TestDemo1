package example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Demo2 {

    public static void main(String[] args) throws IOException {
       WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        List<WebElement> elementList = driver.findElements(By.tagName("a"));
        for(int i=0;i<elementList.size();i++) {
            WebElement element = elementList.get(i);
            System.out.println(element.getAttribute("href"));
            String url = element.getAttribute("href");
            System.out.println(url);
            verifyUrl(url);
        }
    }

    public static void verifyUrl(String url) throws IOException {
        URL link = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection)link.openConnection();
        if(httpURLConnection.getResponseCode() != 200) {
            System.out.println("Broken link");
        }
    }
}
