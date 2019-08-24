package com.vytrack.Notes;

import com.vytrack.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void dismiss(){

        // we navigate to the website
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        BrowserUtils.waitFor(2);

        //Trigger the javaScript alert

        WebElement triggerMethod = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        triggerMethod.click();
        BrowserUtils.waitFor(2);
        Alert alert = driver.switchTo().alert();
        BrowserUtils.waitFor(2);
        alert.dismiss();
        BrowserUtils.waitFor(2);
        String expectedText = "You clicked: Cancel";
        BrowserUtils.waitFor(2);
        WebElement actMessage = driver.findElement(By.xpath("//p[@id='result']"));

        String actualText = actMessage.getText();

        Assert.assertEquals(expectedText, actualText);



    }



}