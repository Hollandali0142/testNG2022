package com.tests;

import com.pages.Day10_C6_TestAdressLoginPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.testng.annotations.Test;

public class Day10_C7_TestAdreessLoginTest {

    @Test
    public void testAdresLogin(){
        //application git https://testyou.in/Login.aspx

        Driver.getDriver().get(ConfigReader.getProperty("Test_address_url"));
        Day10_C6_TestAdressLoginPage testAdressLoginPage=new Day10_C6_TestAdressLoginPage();
        testAdressLoginPage.email.sendKeys(ConfigReader.getProperty("test_address_email"));
        testAdressLoginPage.password.sendKeys(ConfigReader.getProperty("test_address_password"));
        testAdressLoginPage.loginButton.click();



        //driver kapatma
       //Driver.closeDriver();

        /*
        Diyelimki 100 tane test caseniz hepsinde kullanmissiniz
        Daha sonra sifre degisirse ne yaparsiniz
        config.properties olmaz tum bu 100 test case gidip her biri icin sifreyi degistirmemiz cofig.ptoperties
        ile configuration.propertiedeki file gidip sadece orada sifrenin value kismini degistimemiz gerekir

         */

    }


}
