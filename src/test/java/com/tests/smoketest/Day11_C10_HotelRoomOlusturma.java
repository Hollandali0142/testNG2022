package com.tests.smoketest;

import com.github.javafaker.Faker;
import com.pages.DefaultPage;
import com.pages.HotelRoomPege;
import com.pages.LoginPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day11_C10_HotelRoomOlusturma {

    LoginPage loginPage=new LoginPage();
    DefaultPage defaultPage=new DefaultPage();
    HotelRoomPege hotelRoomPege=new HotelRoomPege();

    Faker faker=new Faker();

    @BeforeMethod
    public void setUp(){

        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));

        loginPage.advancedLink.click();

        loginPage.proceedLink.click();

        loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();



        //login basarili oldugunu verify ediyoruz

        Assert.assertTrue(defaultPage.addUserButton.isDisplayed());

        //artik defultPage in icindeyiz



        }


        @Test
        public void hotelRoomOlusturma() throws InterruptedException {

              //hotel management click yap
            defaultPage.hotelManagement.click();



              //hotel rooms click yap
           defaultPage.hotelRooms.click();

            //add HOTELROOM A click yap

           hotelRoomPege.addhotelRoom.click();

         //zorunlu butun alanlari doldurmam lazim
            //id hotel dropdown

            Select select=new Select(hotelRoomPege.idDropDown);
            select.selectByIndex(2);

            //code

            hotelRoomPege.code.sendKeys(faker.code().imei());

            //name

            hotelRoomPege.name.sendKeys(faker.gameOfThrones().character());

            //location

            hotelRoomPege.location.sendKeys(faker.address().fullAddress());

            //descripTion

            hotelRoomPege.Decription.sendKeys(faker.howIMetYourMother().catchPhrase());

            //Price

           //1. yol==> hotelRoomPege.price.sendKeys(faker.code().asin());
            //2.yol
            Actions actions=new Actions(Driver.getDriver());

            actions.dragAndDrop(hotelRoomPege.price600, hotelRoomPege.price).perform();

            //room type
            Select roomtype=new Select(hotelRoomPege.roomType);
            roomtype.selectByVisibleText("Queen");

            //Max Adult
            hotelRoomPege.adultCunt.sendKeys("2");

            //Max CHILDEREN

            hotelRoomPege.maxichildCoud.sendKeys("4");

            //approved
            hotelRoomPege.approvedChekBox.click();

            //save
            hotelRoomPege.save.click();

            //"HotelRoom was inserted successfully "mesajini vrify et

            //WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
            Thread.sleep(3000);
            System.out.println(hotelRoomPege.popupMessge.getText());

           Assert.assertTrue( hotelRoomPege.popupMessge.getText().contains("HotelRoom was inserted successfully"));
    }




}
