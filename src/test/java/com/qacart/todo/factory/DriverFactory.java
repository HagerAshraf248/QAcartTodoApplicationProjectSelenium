package com.qacart.todo.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {

    private WebDriver driver;

    public WebDriver initializeDriver(){
        String brower=System.getProperty("browser","CHROME");
        switch (brower){
             case "CHROME":
                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");

                driver = new ChromeDriver(options);
                break;
            case "FIREFOX" :
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                 break;
            default:
                throw new RuntimeException("Invalid Browser name");
        }
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return  driver;

    }

}
