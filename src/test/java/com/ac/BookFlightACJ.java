package com.ac;

/**
 * Created by tkmap47 on 12/26/15.
 */

        import java.util.concurrent.TimeUnit;

        import static org.testng.AssertJUnit.assertTrue;

        import com.ac.pageobjects.validation.HomePageValidation;
        import org.testng.annotations.*;

        import org.openqa.selenium.*;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.support.ui.Select;

public class BookFlightACJ extends HomePageValidation {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://www.aircanada.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testBookFlightACJ() throws Exception {

        driver.get(baseUrl + "/us/en/home.html");


        validateHomePage(driver);

        // Flight Tab
        btn_FlightTab(driver).click();

        // Home Page

        drpdwn_TripType(driver).selectByVisibleText("One-way");
        txtbx_From(driver).click();
        txtbx_From(driver).sendKeys("San Francisco, California (SFO)");
        txtbx_To(driver).clear();
        txtbx_To(driver).sendKeys("Chennai, India (MAA)");
        selectDate(driver);
        btn_Search(driver).click();


        assertTrue(driver.findElement(By.id("qaid_rdo_out_flight0_0")).isDisplayed());

        driver.findElement(By.id("qaid_rdo_out_flight0_0")).click();
//        driver.findElement(By.id("qaid_rdo_out_flight0_0")).click();
        driver.findElement(By.xpath("//button[@onclick='FFCOForm.check()']")).click();
//        driver.findElement(By.xpath("//button[@onclick='FFCOForm.check()']")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=fbMainContainer | ]]
//        driver.findElement(By.id("fbInspectButton")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]

        // Review Flight
        driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();
//        driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();


        //Sign In
        driver.findElement(By.id("qaid_lnk_sign_in")).click();
//        driver.findElement(By.id("qaid_lnk_sign_in")).click();

        // Travel Details

        new Select(driver.findElement(By.id("qaid_edt_title_passenger0"))).selectByVisibleText("Mr");
        new Select(driver.findElement(By.id("qaid_edt_title_passenger0"))).selectByVisibleText("Mr");
        driver.findElement(By.id("qaid_edt_first_name_passenger0")).clear();
        driver.findElement(By.id("qaid_edt_first_name_passenger0")).sendKeys("Test");
        driver.findElement(By.id("qaid_edt_first_name_passenger0")).clear();
        driver.findElement(By.id("qaid_edt_first_name_passenger0")).sendKeys("Test");
        driver.findElement(By.id("qaid_edt_last_name_passenger0")).clear();
        driver.findElement(By.id("qaid_edt_last_name_passenger0")).sendKeys("Test");
        driver.findElement(By.id("qaid_edt_last_name_passenger0")).clear();
        driver.findElement(By.id("qaid_edt_last_name_passenger0")).sendKeys("Test");
        new Select(driver.findElement(By.id("qaid_cbo_SECgender_passenger0"))).selectByVisibleText("MALE");
        new Select(driver.findElement(By.id("qaid_cbo_SECgender_passenger0"))).selectByVisibleText("MALE");
        new Select(driver.findElement(By.id("qaid_cbo_birth_day_passenger0"))).selectByVisibleText("01");
        new Select(driver.findElement(By.id("qaid_cbo_birth_day_passenger0"))).selectByVisibleText("01");
        new Select(driver.findElement(By.id("dateOfBirthMonth1"))).selectByVisibleText("Jan");
        new Select(driver.findElement(By.id("dateOfBirthMonth1"))).selectByVisibleText("Jan");
        new Select(driver.findElement(By.id("dateOfBirthYear1"))).selectByVisibleText("1987");
        new Select(driver.findElement(By.id("dateOfBirthYear1"))).selectByVisibleText("1987");
        driver.findElement(By.id("qaid_edt_phone_area1")).clear();
        driver.findElement(By.id("qaid_edt_phone_area1")).sendKeys("262");
        driver.findElement(By.id("qaid_edt_phone_area1")).clear();
        driver.findElement(By.id("qaid_edt_phone_area1")).sendKeys("262");
        driver.findElement(By.id("qaid_edt_phone_number1")).clear();
        driver.findElement(By.id("qaid_edt_phone_number1")).sendKeys("3097491");
        driver.findElement(By.id("qaid_edt_phone_number1")).clear();
        driver.findElement(By.id("qaid_edt_phone_number1")).sendKeys("3097491");
        driver.findElement(By.id("qaid_edt_email")).clear();
        driver.findElement(By.id("qaid_edt_email")).sendKeys("test@gmail.com");
        driver.findElement(By.id("qaid_edt_email")).clear();
        driver.findElement(By.id("qaid_edt_email")).sendKeys("test@gmail.com");
        driver.findElement(By.id("continue")).click();
//        driver.findElement(By.id("continue")).click();


        // Billing Information

        new Select(driver.findElement(By.id("qaid_cbo_cc_type"))).selectByVisibleText("Visa");
        new Select(driver.findElement(By.id("qaid_cbo_cc_type"))).selectByVisibleText("Visa");
        driver.findElement(By.id("qaid_edt_cc_number")).clear();
        driver.findElement(By.id("qaid_edt_cc_number")).sendKeys("4111111111111111");
        driver.findElement(By.id("qaid_edt_cc_number")).clear();
        driver.findElement(By.id("qaid_edt_cc_number")).sendKeys("4111111111111111");
        new Select(driver.findElement(By.id("qaid_cbo_cc_month"))).selectByVisibleText("01-Jan");
        new Select(driver.findElement(By.id("qaid_cbo_cc_month"))).selectByVisibleText("01-Jan");
        new Select(driver.findElement(By.id("qaid_cbo_cc_year"))).selectByVisibleText("2018");
        new Select(driver.findElement(By.id("qaid_cbo_cc_year"))).selectByVisibleText("2018");
        driver.findElement(By.cssSelector("option[value=\"2018\"]")).click();
        driver.findElement(By.id("qaid_edt_cc_name")).clear();
        driver.findElement(By.id("qaid_edt_cc_name")).sendKeys("Test");
        driver.findElement(By.id("qaid_edt_cc_name")).clear();
        driver.findElement(By.id("qaid_edt_cc_name")).sendKeys("Test");
        driver.findElement(By.id("qaid_edt_address")).clear();
        driver.findElement(By.id("qaid_edt_address")).sendKeys("test");
        driver.findElement(By.id("qaid_edt_address")).clear();
        driver.findElement(By.id("qaid_edt_address")).sendKeys("test");
        driver.findElement(By.id("qaid_edt_address_second_line")).clear();
        driver.findElement(By.id("qaid_edt_address_second_line")).sendKeys("test");
        driver.findElement(By.id("qaid_edt_address_second_line")).clear();
        driver.findElement(By.id("qaid_edt_address_second_line")).sendKeys("test");
        driver.findElement(By.id("qaid_edt_city")).clear();
        driver.findElement(By.id("qaid_edt_city")).sendKeys("test");
        driver.findElement(By.id("qaid_edt_city")).clear();
        driver.findElement(By.id("qaid_edt_city")).sendKeys("test");
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();

    }

}

