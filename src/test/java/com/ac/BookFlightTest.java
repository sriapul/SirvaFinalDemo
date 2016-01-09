package com.ac;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.reports.ExtentManager;
import com.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

/**
 * Created by tkmap47 on 12/14/15.
 */
public class BookFlightTest {

    ExtentReports extent;
    ExtentTest test;
    ExtentTest parent;
    WebDriver driver;
    String currentRun;

    @BeforeClass
    public void M1(){
        extent = ExtentManager.Instance(this.getClass().getName());
         parent = extent.startTest("Book flight Module");
//        driver = new FirefoxDriver();
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
    public void BookFlight(String From, String To,String description)
    {
        try{

            driver.get("http://www.aircanada.com/en/home.html");
            new Select(driver.findElement(By.id("tripType"))).selectByVisibleText("One-way");
            driver.findElement(By.id("org1")).click();
            driver.findElement(By.id("org1")).click();
            driver.findElement(By.id("org1")).click();
            driver.findElement(By.id("org1")).click();
            driver.findElement(By.id("org1")).click();
            driver.findElement(By.cssSelector("label.origin")).click();
            driver.findElement(By.id("org1")).click();
            driver.findElement(By.cssSelector("label.origin")).click();
            driver.findElement(By.id("org1")).click();
            driver.findElement(By.cssSelector("label.origin")).click();
            driver.findElement(By.id("org1")).click();
            driver.findElement(By.cssSelector("label.origin")).click();
            driver.findElement(By.id("org1")).clear();
            driver.findElement(By.id("org1")).sendKeys("");
            driver.findElement(By.id("org1")).click();
            driver.findElement(By.id("org1")).clear();
            driver.findElement(By.id("org1")).sendKeys("San Francisco, California (SFO)");
            driver.findElement(By.id("dest1")).clear();
            driver.findElement(By.id("dest1")).sendKeys("");
            driver.findElement(By.id("dest1")).clear();
            driver.findElement(By.id("dest1")).sendKeys("Chennai, India (MAA)");
            driver.findElement(By.id("c1c26")).click();
            driver.findElement(By.cssSelector("#searchButton > span")).click();
            driver.findElement(By.id("qaid_rdo_out_flight0_6")).click();
            driver.findElement(By.id("qaid_rdo_out_flight0_6")).click();
            driver.findElement(By.xpath("//button[@onclick='FFCOForm.check()']")).click();
            driver.findElement(By.xpath("//button[@onclick='FFCOForm.check()']")).click();
            driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();
            driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();
            driver.findElement(By.id("qaid_lnk_sign_in")).click();
            driver.findElement(By.id("qaid_lnk_sign_in")).click();
            new Select(driver.findElement(By.id("qaid_edt_title_passenger0"))).selectByVisibleText("Mrs");
            new Select(driver.findElement(By.id("qaid_edt_title_passenger0"))).selectByVisibleText("Mrs");
            driver.findElement(By.id("qaid_edt_first_name_passenger0")).clear();
            driver.findElement(By.id("qaid_edt_first_name_passenger0")).sendKeys("Sridhar");
            driver.findElement(By.id("qaid_edt_first_name_passenger0")).clear();
            driver.findElement(By.id("qaid_edt_first_name_passenger0")).sendKeys("Sridhar");
            driver.findElement(By.id("qaid_edt_last_name_passenger0")).clear();
            driver.findElement(By.id("qaid_edt_last_name_passenger0")).sendKeys("Jayapaul");
            driver.findElement(By.id("qaid_edt_last_name_passenger0")).clear();
            driver.findElement(By.id("qaid_edt_last_name_passenger0")).sendKeys("Jayapaul");
            new Select(driver.findElement(By.id("qaid_cbo_SECgender_passenger0"))).selectByVisibleText("MALE");
            new Select(driver.findElement(By.id("qaid_cbo_SECgender_passenger0"))).selectByVisibleText("MALE");
            new Select(driver.findElement(By.id("qaid_cbo_birth_day_passenger0"))).selectByVisibleText("01");
            new Select(driver.findElement(By.id("qaid_cbo_birth_day_passenger0"))).selectByVisibleText("01");
            new Select(driver.findElement(By.id("dateOfBirthMonth1"))).selectByVisibleText("Apr");
            new Select(driver.findElement(By.id("dateOfBirthMonth1"))).selectByVisibleText("Apr");
            driver.findElement(By.cssSelector("#dateOfBirthMonth1 > option[value=\"04\"]")).click();
            new Select(driver.findElement(By.id("dateOfBirthYear1"))).selectByVisibleText("1984");
            new Select(driver.findElement(By.id("dateOfBirthYear1"))).selectByVisibleText("1984");
            driver.findElement(By.cssSelector("option[value=\"1984\"]")).click();
            driver.findElement(By.id("qaid_edt_phone_area1")).clear();
            driver.findElement(By.id("qaid_edt_phone_area1")).sendKeys("000");
            driver.findElement(By.id("qaid_edt_phone_area1")).clear();
            driver.findElement(By.id("qaid_edt_phone_area1")).sendKeys("000");
            driver.findElement(By.id("qaid_edt_phone_number1")).clear();
            driver.findElement(By.id("qaid_edt_phone_number1")).sendKeys("0000000");
            driver.findElement(By.id("qaid_edt_phone_number1")).clear();
            driver.findElement(By.id("qaid_edt_phone_number1")).sendKeys("0000000");
            driver.findElement(By.id("qaid_edt_email")).clear();
            driver.findElement(By.id("qaid_edt_email")).sendKeys("test@gmail.com");
            driver.findElement(By.id("qaid_edt_email")).clear();
            driver.findElement(By.id("qaid_edt_email")).sendKeys("test@gmail.com");
            driver.findElement(By.id("continue")).click();
            driver.findElement(By.id("continue")).click();
            driver.findElement(By.id("purchaseButtonText")).click();
            driver.findElement(By.id("purchaseButtonText")).click();

        }catch(Exception e){
            test.log(LogStatus.ERROR, e.getMessage());
//            System.out.println(Utility.captureScreenshot(driver, currentRun.replaceAll(" ", "")));
            test.log(LogStatus.FAIL, "Adding ScreenShot", test.addScreenCapture(Utility.captureScreenshot(driver, currentRun)));
//            test.log(LogStatus.FAIL,"Adding ScreenShot",test.addScreenCapture(Utility.captureScreenshot(driver, "M3")));
//            Assert.fail("<a href=\"/Selenium_Databinding/target/ExtentReport/SearchFlightfromSFOtoMAA.png\">Link to Failed ScreenShot</a>");
//            Assert.fail("%3Ca%20href%3D%94%2FSelenium_Databinding%2Ftarget%2FExtentReport%2FSearchFlightfromSFOtoMAA.png%94%3EScreen%20Shot%20Path%3C%2Fa%3E");
            Assert.fail("Test Failed");

        }finally {

        }
    }


    @AfterMethod
    public void tearDown(ITestResult result)

    {
        System.out.println("After test");
        System.out.println(result.getStatus());
        System.out.println(ITestResult.FAILURE);

        if(result.getStatus()==ITestResult.FAILURE)
        {
            test.log(LogStatus.FAIL,"Adding ScreenShot",test.addScreenCapture(Utility.captureScreenshot(driver, currentRun)));
        }


        parent.appendChild(test);


        driver.quit();

    }

    @AfterClass
    public void suiteDown(){

        extent.endTest(parent);
        extent.flush();
        extent.close();
    }


    public static void main(String[] args) {

        String test = "Sridhar Jyapaul";

        System.out.println(test);


    }


}
