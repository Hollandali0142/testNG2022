package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class MainPage {

    public MainPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(linkText = "Log in")
   public WebElement mainPageLoginLink;

    @FindBy(id = "details-button")

    public WebElement advencedlink;

    @FindBy(id = "proceed-link")
    public WebElement proceedlink;
}
