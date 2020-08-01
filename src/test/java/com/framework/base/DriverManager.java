package com.framework.base;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    public WebDriver driver;
    Properties prop;


    public void loadProperty(){
        try{
            InputStream inputStream=new FileInputStream(System.getProperty("user.dir").
                    concat(File.separator).
                    concat("config.properties"));
            prop=new Properties();
            prop.load(inputStream);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public String getProperty(String propertyName){
        try{
            if(prop==null){
                loadProperty();
                System.out.println("Executed");
            }
            return prop.getProperty(propertyName);
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void getDriver(){
        String browser=getProperty("Browser");

        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir")
                            + "\\Resources\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver",
                    "\\Resources\\geckodriver.exe");
            // DesiredCapabilities capabilities=DesiredCapabilities.firefox();
            //capabilities.setCapability("marionette", true);
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver",
                    System.getProperty("user.dir")
                            + "\\Resources\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
}
