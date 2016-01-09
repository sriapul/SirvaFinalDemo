package com.flight;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.reports.ExtentManager;
import com.utilities.Utility;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.net.MalformedURLException;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by tkmap47 on 12/14/15.
 */
public class FlightStatus extends TestBase {

    ExtentReports extent;
    ExtentTest test;
    ExtentTest parent;
//    WebgetDriver() getDriver();
    String currentRun;

    @BeforeClass
    public void M1(){
        extent = ExtentManager.Instance(this.getClass().getName());
        parent = extent.startTest("flight Status Module");
//        getDriver() = new FirefoxgetDriver()();
    }

    @DataProvider(name = "Travel",parallel = false)
    public Object[][] createData() {

//        Object[][] retObjArr= BaseSpec.getExcelData("G:\\share\\IS\\A162\\A163\\Sridhar\\TDM Sku Validation\\Sku_11.xlsx", "Sheet1");
        Object[][] retObjArr= {{"San Francisco, California (SFO)","Chennai, India (MAA)","Search flight from SFO to MAA"},
                {"San José, Mineta San José Int'l, California (SJC)","Chennai, India (MAA)","Search flight from SJC to MAA"}
        };

        return retObjArr;
    }

    @Test(dataProvider = "Travel")
    public void getFlightStatusTest(String From, String To,String description) throws  InterruptedException, MalformedURLException {

        try {

//        getDriver() = new FirefoxgetDriver()();
         getDriver();
            
            getDriver().get("http://www.aircanada.com/en/home.html");

        currentRun = description;

        test = extent.startTest("Get flight Status Test - From = " + From + " To " + To, "Verify displayed result");

        test.log(LogStatus.INFO,"Test Started");

        getDriver().findElement(By.id("tab-flightStatus")).click();

        test.log(LogStatus.PASS,"Click flight Status tab");

        getDriver().findElement(By.id("fs-byCity-from")).clear();
        getDriver().findElement(By.id("fs-byCity-from")).sendKeys("San Francisco, California (SFO)");

        test.log(LogStatus.PASS,"Enter City of flight departure");


        getDriver().findElement(By.id("fs-byCity-to")).clear();
        getDriver().findElement(By.id("fs-byCity-to")).sendKeys("Chennai, India (MAA)");


        getDriver().findElement(By.id("c1c24")).click();
        getDriver().findElement(By.id("c1c27")).click();

        test.log(LogStatus.PASS,"Enter City of flight Arrival");

        getDriver().findElement(By.id("fs-byCity-search")).click();

        test.log(LogStatus.PASS,"Click on Search Button");

       assertTrue(getDriver().findElement(By.linkText("AC758")).isDisplayed());

        test.log(LogStatus.PASS,"Verify displayed flight details");
    }catch(Exception e){
        test.log(LogStatus.ERROR, e.getMessage());
//            System.out.println(Utility.captureScreenshot(getDriver(), currentRun.replaceAll(" ", "")));
        test.log(LogStatus.FAIL, "Adding ScreenShot", test.addScreenCapture(Utility.captureScreenshot(getDriver(), currentRun.replaceAll(" ", ""))));
//            Assert.fail("<a href=\"/Selenium_Databinding/target/ExtentReport/SearchFlightfromSFOtoMAA.png\">Link to Failed ScreenShot</a>");
//            Assert.fail("%3Ca%20href%3D%94%2FSelenium_Databinding%2Ftarget%2FExtentReport%2FSearchFlightfromSFOtoMAA.png%94%3EScreen%20Shot%20Path%3C%2Fa%3E");
//            test.log(LogStatus.FAIL,"Adding ScreenShot",test.addScreenCapture(Utility.captureScreenshot(getDriver(), "M3")));
    }finally {

        }

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws MalformedURLException

    {
        System.out.println("After test");
        System.out.println(result.getStatus());
        System.out.println(ITestResult.FAILURE);

        if(result.getStatus()==ITestResult.FAILURE)
        {
            test.log(LogStatus.FAIL,"Adding ScreenShot",test.addScreenCapture(Utility.captureScreenshot(getDriver(), currentRun)));
        }


//        extent.endTest(test);

        parent.appendChild(test);


        getDriver().quit();

    }

    @AfterClass
    public void suiteDown(){

        extent.endTest(parent);

        extent.flush();
        extent.close();
    }


}
