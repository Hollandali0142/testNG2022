package com.tests.smoketest;

import com.pages.DefaultPage;
import com.pages.LoginPage;
import com.pages.MainPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day10_C8_PositiveLoginTest {

    @Test

    public void positiveLoginTest(){

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        //1-page object olustur ==>mainPage ve LoginPage olusturduk
        //2-test class olustur duk
            //page object olustur
        //-mainPage objectleri olustur
        //-LoginPage objectleri olustur

        MainPage mainPage =new MainPage();
        mainPage.advencedlink.click();
        mainPage.proceedlink.click();
        mainPage.mainPageLoginLink.click();

        //bu noktada loginPage teyiz
        //LoginPage object olustur

        LoginPage loginPage=new LoginPage();

       loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
       loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));

        loginPage.loginButton.click();

        //Adduser buttonunu kullanarak defaul page giris yaptigimizi verify edin

        //Bu noltada defaultPage clasindayiz

        DefaultPage defaultPage=new DefaultPage();
        defaultPage.addUserButton.isDisplayed();
        Assert.assertTrue(defaultPage.addUserButton.isDisplayed());
    }



}
