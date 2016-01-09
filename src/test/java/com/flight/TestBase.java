package com.flight;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by tkmap47 on 12/22/15.
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected ThreadLocal<RemoteWebDriver> threadDriver = null;
    protected ThreadLocal<RemoteWebDriver> threadDriver1 = null;
    private static ChromeDriverService service;

//    @BeforeMethod
//    public void setUp() throws MalformedURLException {
//        threadDriver = new ThreadLocal<RemoteWebDriver>();
//        DesiredCapabilities dc = new DesiredCapabilities();
//        FirefoxProfile fp = new FirefoxProfile();
//        dc.setCapability(FirefoxDriver.PROFILE, fp);
//        dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
//        threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc));
//    }



    @BeforeMethod
    public void setUp() throws MalformedURLException {
        threadDriver = new ThreadLocal<RemoteWebDriver>();
        DesiredCapabilities dc = new DesiredCapabilities();
        FirefoxProfile fp = new FirefoxProfile();
        dc.setCapability(FirefoxDriver.PROFILE, fp);
        dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        System.out.println("I am here");
        threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc));
//        threadDriver.set(new RemoteWebDriver(new URL("http://10.0.0.42:5555/wd/hub"), dc.firefox()));
    }

    public WebDriver getDriver() {
        return threadDriver.get();
    }

    public WebDriver getChoDriver() {

        threadDriver = new ThreadLocal<RemoteWebDriver>();
//        DesiredCapabilities dc = new DesiredCapabilities();
//        FirefoxProfile fp = new FirefoxProfile();
//        dc.setCapability(FirefoxDriver.PROFILE, fp);
//        dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
//        System.setProperty("webdriver.chrome.driver", "/Users/tkmap47/Documents/Selenium_Databinding/src/main/resources/chromedriver");
//        System.setProperty("webdriver.chrome.driver", "C:/Sridhar/chromedriver.exe");
//        File file = new File("C:\\Sridhar\\chromedriver.exe");
        //File file1 = new File("C:\\Sridhar\\MultiBrowser\\Selenium_Databinding (1)\\Selenium_Databinding\\src\\extent-config.xml");
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        System.setProperty("webdriver.chrome.driver", "C:\\Sridhar\\chromedriver.exe");

        System.out.println("I am here");
//        threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome()));
//        new ChromeDriver();
        try {
        threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return threadDriver.get();
    }


    public static void main(String[] args) {
        TestBase tb = new TestBase();

//        System.setProperty("webdriver.chrome.driver", "C:\\Sridhar\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://www.google.com");


tb.getChoDriver().get("http://www.google.com");
//        tb.getChoDriver.get("http://www.google.com");

    }

    @AfterMethod
    public void closeBrowser() {
        getDriver().quit();
        getChoDriver().quit();

    }
}
