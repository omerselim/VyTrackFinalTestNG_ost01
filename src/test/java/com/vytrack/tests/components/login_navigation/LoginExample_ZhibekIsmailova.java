package com.vytrack.tests.components.login_navigation;


import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginExample_ZhibekIsmailova extends TestBase {

    //4 different credentials
    //set of username and password
    @Test(dataProvider="vytrackData")
    public void LoginToVytrack(String username, String password) {
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        driver.findElement(By.id("_submit")).click();

        BrowserUtils.waitPlease(1);
        if (driver.getTitle().contains("Dashboard")) {
            System.out.println("Title verified,User is able to log in successfully");
        } else {
            System.out.println("Invalid user name or password.");
        }
        //validating
        Assert.assertTrue(driver.getTitle().contains("Dashboard"));


    }

    @DataProvider(name="vytrackData")
    //should start with  public static Object[][]
    public static Object[][] passData() {
        //specifying number of rows[4] and columns[2]
        Object[][] data=new Object[4][2];

        data[0][0]="user36";//first row first column
        data[0][1]="UserUser123";//first row second column
        data[1][0]="storemanager75";//second row first column
        data[1][1]="UserUser123";//second row second column
        data[2][0]="salesmanager137";//third row first column
        data[2][1]="UserUser123";//third row second column
        data[3][0]="wrongusername";//fourth fow first column
        data[3][1]="wrongpassword";//fourth row second column
        return data;


    }
}