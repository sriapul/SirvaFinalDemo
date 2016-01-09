package com.flight;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.reports.ExtentManager;
import com.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.net.MalformedURLException;

/**
 * Created by tkmap47 on 12/14/15.
 */
public class SearchFlight extends TestBase {

    ExtentReports extent;
    ExtentTest test;
    ExtentTest parent;
//    WebDriver getDriver();
    String currentRun;

    @BeforeClass
    public void M1(){
        extent = ExtentManager.Instance(this.getClass().getName());
         parent = extent.startTest("Search flight Module");
//        getDriver() = new FirefoxDriver();
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
    public void SearchFlight(String From, String To,String description) throws InterruptedException, MalformedURLException {

        try {
            getDriver();

            getDriver().get("http://www.aircanada.com/en/home.html");

            currentRun = description;

            test = extent.startTest("Search flight Test - From = " + From + " To " + To, "Verify displayed result");

            test.log(LogStatus.INFO,"Test Started");

            new Select(getDriver().findElement(By.id("tripType"))).selectByVisibleText("Round-trip");

            test.log(LogStatus.PASS,"Selected TripType");

            getDriver().findElement(By.id("org1")).clear();

            getDriver().findElement(By.id("org1")).sendKeys(From);

            getDriver().findElement(By.xpath(".//*[@id='citylist']/div")).click();

            test.log(LogStatus.PASS, "Selected From");

            getDriver().findElement(By.id("dest1")).clear();

            getDriver().findElement(By.xpath(".//*[@id='dest1']")).sendKeys(To);

            getDriver().findElement(By.xpath(".//*[@id='citylist']/div")).click();

            test.log(LogStatus.PASS, "Selected To");

            getDriver().findElement(By.xpath(".//*[@id='departure1']")).click();

            Thread.sleep(1000);

            getDriver().findElement(By.xpath(" .//*[@id='c1c30']")).click();

//            getDriver().findElement(By.xpath(".//*[@id='departure1']")).sendKeys("26/01/2016");

            test.log(LogStatus.PASS,"Selected Departure Date");

            getDriver().findElement(By.xpath(".//*[@id='departure2']")).click();

            Thread.sleep(1000);

            getDriver().findElement(By.xpath(" .//*[@id='c1c33']")).click();

//            getDriver().findElement(By.xpath(".//*[@id='departure2']")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "31/01/2016");
//            getDriver().findElement(By.xpath(".//*[@id='departure2']")).sendKeys("31/01/2016");

            test.log(LogStatus.PASS,"Selected ReturnDate");

            if (!getDriver().findElement(By.xpath(".//*[@id='Flexible']/label/input")).isSelected()){

                getDriver().findElement(By.xpath(".//*[@id='Flexible']/label/input")).click();
            }

            getDriver().findElement(By.xpath(".//*[@id='searchButton']/span")).click();

            test.log(LogStatus.PASS,"Click Search Button");

            Thread.sleep(10000);

            getDriver().findElement(By.xpath(" .//*[@id='timeRemainingForPageExpire']")).getText().matches("([0-9]):([0-9])([0-9])");

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
