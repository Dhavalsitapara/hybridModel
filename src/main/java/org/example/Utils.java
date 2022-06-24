package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utils extends BasePage{

    public static void typeText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    //Click On Element
    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //Time Stamp
    public static String randomDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        return formatter.format(date);
    }

    public static void selectFromDropDownIndexValue(By by, int indexvalue){
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(indexvalue);
    }
    public static void selectFromDropDownVisibleText(By by, String textvalue){
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(textvalue);
    }
    public static void sleep(){
        try{
            Thread.sleep(1000*1);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    // Attribute
    public static void typeAttribute(By by, String text)
    {
        driver.findElement(by).getAttribute(text);
    }

    // Send Text Values
    public static void driverSendValue(By by, String value)
    {
        driver.findElement(by).sendKeys(value);
    }

    //Text From Element
    public static String getTexFromElement(By by)
    {
        return driver.findElement(by).getText();
    }

    //Wait for URL
    public static void driverWaitsUrl(int time, String url)
    {
        WebDriverWait wait01 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait01.until(ExpectedConditions.urlToBe(url));
    }

    //Wait For Element To be ClickAble
    public static void driverWaitsUntil(By by, int time)
    {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    //wait until Presence of Element (All)
    public static void driverPresenceofElement(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    //Wait until presence of Element located
    public static void driverPresenceOfElement(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public static void verifyCurrentURL(String URL){
        Assert.assertEquals(driver.getCurrentUrl(), URL);
    }


    //Url Fraction or Contains
    public static void driverURLContains(String URLContains, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlContains(URLContains));
    }

    //wait until Element Title Contains
    public static void driverElementTitleContains(String title, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleContains(title));
    }

    //Wait until Invisibility of WebElement
    public static void driverInvisibilityOfElement(WebElement element, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    //Wait until Attribute not Empty
    public static void driverAttributeNotEmpty(WebElement webelement, String attribute, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(webelement,attribute));
    }

    //Wait until Element to be Selected (locator)
    public static void driverElementToBeSelected(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //Wait until TextToBe
    public static void drivertextToBe(By  by,String value, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textToBe(by,value));
    }

    public static void takeSnapShot(String a)
    {

        //Convert web driver object to TakeScreenShort
        TakesScreenshot scrShot = ((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Copy file at destination
        try{
            FileUtils.copyFile(srcFile,new File("Screenshots\\"+a+randomDate()+".png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
