package com.ac.pageobjects.validation;

import com.ac.pageobjects.execution.HomePageExecution;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertTrue;


/**
 * Created by tkmap47 on 12/14/15.
 */
public class HomePageValidation extends HomePageExecution {

    public void validateHomePage(WebDriver driver){
        assertTrue(driver.findElement(By.xpath(".//*[@id='linkbook']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath(".//*[@id='tabContent-flights']/h2")).isDisplayed());
        assertTrue(driver.findElement(By.xpath(".//*[@id='tab-flightPasses']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath(".//*[@id='inpageSearchPage']/main/section[4]/div")).isDisplayed());
        assertTrue(driver.findElement(By.xpath(".//*[@id='inpageSearchPage']/main/section[5]/section[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath(".//*[@id='inpageSearchPage']/main/section[5]/section[2]")).isDisplayed());
    }

}
