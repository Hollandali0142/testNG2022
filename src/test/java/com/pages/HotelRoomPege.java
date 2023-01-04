package com.pages;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class HotelRoomPege {

        public HotelRoomPege(){

            PageFactory.initElements(Driver.getDriver(),this);

        }

        @FindBy(partialLinkText = "ADD HOTELROOM")
        public WebElement addhotelRoom;

        @FindBy(id = "IDHotel")
        public WebElement idDropDown;

        @FindBy(id = "Code")
        public WebElement code;

        @FindBy(id = "Name")
        public WebElement name;

        @FindBy(id="Location")
        public WebElement location;

        @FindBy(xpath = "//textarea[@dir='ltr']")
        public WebElement Decription;

        @FindBy(id="Price")
        public WebElement price;

        @FindBy(id = "IDGroupRoomType")
        public WebElement roomType;

        @FindBy(id="MaxAdultCount")
        public WebElement adultCunt;

        @FindBy(id = "MaxChildCount")
        public WebElement maxichildCoud;

        @FindBy(id="IsAvailable")
        public WebElement approvedChekBox;

        @FindBy(id = "btnSubmit")
        public WebElement save;

        @FindBy(xpath = "//li[@data-id='600']")
        public WebElement price600;

        @FindBy(xpath = "//div[@class='bootbox-body']")
        public WebElement  popupMessge;



}
