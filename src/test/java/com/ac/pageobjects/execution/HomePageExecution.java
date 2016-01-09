package com.ac.pageobjects.execution;

import com.BaseTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by tkmap47 on 12/14/15.
 */
public class HomePageExecution extends BaseTest{

    private static WebElement element = null;
    private static Select selection = null;

    public static WebElement btn_FlightTab(WebDriver driver){

        try {
            element = driver.findElement(By.id("tab-flights"));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Element Not Found");

        }
        return element;
    }

    public static Select drpdwn_TripType(WebDriver driver){

        try{
            selection  =  new Select(driver.findElement(By.id("tripType")));
        }catch (Exception e){
            e.printStackTrace();

            Assert.fail("Element Not Found");
        }
        return selection;
    }

    public static WebElement txtbx_From(WebDriver driver){
        try {
            element = driver.findElement(By.xpath(".//*[@id='org1']"));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Element Not Found");

        }
        return element;

    }

    public static WebElement txtbx_To(WebDriver driver){
        try {
            element = driver.findElement(By.id("dest1"));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Element Not Found");
        }
        return element;

    }

    public static WebElement btn_Search(WebDriver driver){

        try {
            element = driver.findElement(By.cssSelector("#searchButton > span"));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Element Not Found");

        }
        return element;
    }

    public void selectDate(WebDriver driver){

        try {
            driver.findElement(By.id("departure1")).click();
            driver.findElement(By.id("departure1")).clear();
            driver.findElement(By.xpath(".//*[@id='calarrowfwd']")).click();
            driver.findElement(By.xpath(".//*[@id='c1c36']")).click();

        }catch (Exception e){

            e.printStackTrace();
            Assert.fail("Element Not Found");
        }


    }
}
