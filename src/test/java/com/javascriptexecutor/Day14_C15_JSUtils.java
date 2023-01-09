package com.javascriptexecutor;

import com.pages.LoginPage;
import com.pages.MainPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import com.utilities.JSUtils;
import com.utilities.ReusableMethods;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Day14_C15_JSUtils {

    MainPage mainPage;
    LoginPage loginPage;



    @Test
    public void scrollIntoView(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));//MainPege
        mainPage=new MainPage();
        try {
            mainPage.advencedlink.click();
            mainPage.proceedlink.click();
        }catch(Exception e){

            System.out.println("advancedLink gorunmedi");
        }

    WebElement haveAQuestion = Driver.getDriver().findElement(By.xpath("//*[.='Have a Questions?']"));
        JSUtils.scrollIntoViewJS(haveAQuestion);
       ReusableMethods.waitFor(3);//bekleme
        //1.yol
       // Assert.assertEquals(haveAQuestion.getText(),"Have a Questions?");
        //2.yol
        Assert.assertTrue(haveAQuestion.isDisplayed());



    }

    @Test
    public void clickByJS(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        mainPage=new MainPage();
        try {
            mainPage.advencedlink.click();
            mainPage.proceedlink.click();
        }catch(Exception e){

            System.out.println("advancedLink gorunmedi");
        }

            //1.yol
       // mainPage.mainPageLoginLink.click();

        //loginPage=new LoginPage();

        //2.yol

     //  WebElement loginLink= Driver.getDriver().findElement(By.linkText("Log in"));
      // JSUtils.clickElementByJS(loginLink);

     WebElement  checkElementByJs=Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
       JSUtils.clickElementByJS(checkElementByJs);


    }

    @Test
    public void flashJS(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        mainPage=new MainPage();
        try {
            mainPage.advencedlink.click();
            mainPage.proceedlink.click();
        }catch(Exception e){

            System.out.println("advancedLink gorunmedi");
        }

        WebElement  checkAvailabilityButton=Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.flash(checkAvailabilityButton);


    }

    @Test
    public void chanceColor(){

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        mainPage=new MainPage();
        try {
            mainPage.advencedlink.click();
            mainPage.proceedlink.click();
        }catch(Exception e){

            System.out.println("advancedLink gorunmedi");
        }

        WebElement  checkAvailabilityButton=Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
            JSUtils.changeColor("red",checkAvailabilityButton);

    }

        @AfterMethod
    public void closeDriver(){

        Driver.closeDriver();



        }
}
