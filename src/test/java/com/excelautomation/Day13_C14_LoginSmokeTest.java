package com.excelautomation;

import com.pages.DefaultPage;
import com.pages.LoginPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import com.utilities.ExcelUtil;

import java.util.List;
import java.util.Map;

public class Day13_C14_LoginSmokeTest {


    ExcelUtil excelUtil;//ExcelUtili klasorunu kullanmak icin ayni isim ile obje olusturduk

        //datayi key-value pairs seklinde (username, password) al
        //Bir Map olusturabiliriziz==>Map<String, String> :{manager, Manager1!}
        //bir List Map olusturabiliriz==>List<Map<String, String> : {{manager, Manager1!}, {manager5, Manager5!},{manager12, Manager12!}}

            List<Map<String,String>> testData;

            //page object model

            LoginPage loginPage;
            DefaultPage defaultPage;

            public void setUp(){

                Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));

                loginPage =new LoginPage();



            }



}
