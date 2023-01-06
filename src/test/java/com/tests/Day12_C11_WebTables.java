package com.tests;

import com.pages.DefaultPage;
import com.pages.HotelRoomPege;
import com.pages.LoginPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Day12_C11_WebTables {


//    When kullanici application'da HotelRoom sayfasina gider
    // Log in https://www.carettahotel.com/
    // Hotel Management'e Click yapar
    // Hotel Rooms'a Click yapar
//    test method: entireTable() ve tum header'lari yazdir
//    test method: printRows() ve tum row'lari ile 4 row'daki elementi yazdir
//    test method: printCells() ve table body'dek' cells'lerin toplam sayilarini yazdir ve tum cell'leri yazdir
//    test method: printColumns() ve columns'larin toplam sayisini yazdir ve 5. column yazdir
//    test method: printData(int row, int column); Bu method veriline cell'i yazdirmali
//    ornek : printData(2,3); 2. row ve 3 column yazdirmali

     LoginPage loginPage=new LoginPage();
     DefaultPage defaultPeg=new DefaultPage();
     HotelRoomPege hotelRoomPege=new HotelRoomPege();

        @BeforeMethod
    public void setUp(){
            Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));//Driver sinif ismini kullanarak o sinifa giitk

            //private isterse
            loginPage.advancedLink.click();
            loginPage.proceedLink.click();

            //kullanici adi ve sifre gonderecegiz
            loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
            loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
            loginPage.loginButton.click();

            //login basarili oldugunu assert edelim

            Assert.assertTrue(defaultPeg.addUserButton.isDisplayed());

            // Hotel Management'e Click yapar

            defaultPeg.hotelManagement.click();

            // Hotel Rooms'a Click yapar

            defaultPeg.hotelRooms.click();

        }
    //    test method: entireTable() ve tum header'lari yazdir
        @Test
    public void entireTable(){

          //  setUp();==>bifore yazamadanda bu metd ile islem yapabiliriz
            System.out.println("tumtablo");
            System.out.println("tum satir");


            WebElement tableBody=Driver.getDriver().findElement(By.xpath("//table//tbody"));
            System.out.println(tableBody.getText());

            //ve tum headerleri yazdir

            List<WebElement>tumHeader= Driver.getDriver().findElements(By.xpath("//th"));

            for(WebElement herHeader:tumHeader){

                System.out.println(herHeader.getText()+ " ");

            }

        }

    //    test method: printRows() ve tum row'larin sayisi ile 4. row'daki elementi yazdir

     @Test
   public void printRows() {

       System.out.println("Print Rows");


       List<WebElement> tumRows = Driver.getDriver().findElements(By.xpath("//tbody//tr"));

       int satirNumarasi = 1;
      for (WebElement herRow : tumRows) {
         System.out.println("Satir: " + satirNumarasi + "=" + herRow.getText());
           satirNumarasi++;
       }
        //4.row'daki elementi yazdir

       WebElement row4 = Driver.getDriver().findElement(By.xpath("//tbody//tr[4]"));
       System.out.println("Row 4 =>" + row4.getText());

       Driver.closeDriver();

    }

        //test method: printCells() ve table body'dek' cells'lerin toplam sayilarini yazdir ve tum cell'leri tek tekyazdir

         @Test
        public void  printCells(){

        List<WebElement>tumCells= Driver.getDriver().findElements(By.xpath("//tbody//td"));
      //  table body'dek' cells'lerin toplam sayilarini yazdir
        System.out.println("Toplam cell sayisi=>" + tumCells.size());

        // tum cell'leri tektek yazdir

             int cellNumarasi=1;
        for (WebElement herCell : tumCells){
         System.out.println(herCell.getText());
         cellNumarasi++;
        }
       Driver.closeDriver();

         }


        //    test method: printColumns() ve columns'larin toplam sayisini yazdir ve 5. column yazdir

            @Test
            public void printColumns(){

            //olumns'larin toplam sayisini yazdir
                List<WebElement>tumHeader= Driver.getDriver().findElements(By.xpath("//th"));
                int ColumSayisi=tumHeader.size();
                System.out.println(ColumSayisi+ "column vardir");

        //5. column yazdir

         List<WebElement>column5Data= Driver.getDriver().findElements(By.xpath("//table//tbody//tr//td[5]"));

              int hucreNumarasi=1;
              for (WebElement herHucre:column5Data){

              System.out.println("hucre "+ hucreNumarasi+ ":" +herHucre.getText());
              hucreNumarasi++;
           }
  }


   //    test method: printData(int row, int column); Bu method veriline cell'i yazdirmali

         @Test
         public void printData(int row, int column) {
             //    ornek : printData(2,3); 2. row ve 3 column yazdirmali
         }


       }



