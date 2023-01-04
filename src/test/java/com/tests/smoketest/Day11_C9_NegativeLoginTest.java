package com.tests.smoketest;

import com.pages.LoginPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day11_C9_NegativeLoginTest {
    /*
    invalidPassword()
    When Kullanıcı sadece yanlış password girer
    Then Kullanıcı ‘wrong password’ mesajını verify eder
    Test Data:
    Url: http://www.carettahotel.com/
    username : manager
    password  : Manage
     */

    LoginPage loginPage=new LoginPage();

    @Test
    public void invaLidPassword() {

        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));

        LoginPage loginPage=new LoginPage();
        loginPage.advancedLink.click();
        loginPage.proceedLink.click();

        //When kullanicisi yanlis password girer

        loginPage.username.sendKeys("manager");//kullanici adi dogrudur
        loginPage.password.sendKeys("Manage");//kullanici adi yanlistir

        loginPage.loginButton.click();

        //Then Kullanıcı ‘Wrong password’ mesajını verify eder

        System.out.println(loginPage.errorMassage.getText());

        Assert.assertTrue(loginPage.errorMassage.getText().contains("Wrong password"));//wrong buyuk yazinca test basarili oldu

        //Then
        Driver.closeDriver();

    }
//    invalidID()
//    When Kullanıcı sadece yanlış username girer
//    Then Kullanıcı ‘Try again please’ mesajını verify eder
//    Test Data:
//    Url: http://www.carettahotel.com/
//    username : manager123
//    password  : Manager1!
        @Test
        public void invaLidID(){

        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
            // LoginPage loginPage=new LoginPage();==>static yaptik sini8fin altina koyduk

            loginPage.advancedLink.click();
            loginPage.proceedLink.click();


            //    When Kullanıcı sadece yanlış username girer

            loginPage.username.sendKeys(ConfigReader.getProperty("wrong_manager_username"));
            loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
            loginPage.loginButton.click();

           // Then Kullanıcı ‘Try again please’ mesajını verify eder

       String actualMessage=loginPage.errorMassage.getText();

            Assert.assertTrue(actualMessage.contains("Try again please"));
            Driver.closeDriver();
    }


    /*
    invalidIDAndPassword()
When Kullanıcı hem yanlış username ve password girer
Then Kullanıcı ‘Username or password is incorrect, please correct them and try again’ mesajını verify eder
Test Data:
Url: http://www.carettahotel.com/
username : manager123
password  : Manage!

     */

    @Test
    public void invalidIDAndPassword(){

        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        loginPage.advancedLink.click();
        loginPage.proceedLink.click();

      //  When Kullanıcı hem yanlış username ve password girer

        loginPage.username.sendKeys(ConfigReader.getProperty("wrong_manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("rong_manager_Password"));
        loginPage.loginButton.click();

      //Then Kullanıcı ‘Username or password is incorrect, please correct them and try again’ mesajını verify eder

           String actuelMessag = loginPage.errorMassage.getText();

           Assert.assertTrue(actuelMessag.contains("Username or password is incorrect, please correct them and try again"));

           Driver.closeDriver();
    }


}
