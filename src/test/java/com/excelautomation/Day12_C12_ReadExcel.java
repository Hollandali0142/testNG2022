package com.excelautomation;

import com.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day12_C12_ReadExcel {

    /*
    Import the apache poi dependency in your pom file
    resources package olustur > java altinda acilmali (java'ya sag tikla ve dosyayi olustur)
    Add the excel file on the resources folder
    Yeni package olustur: excelautomation
    Yeni class olustur : ReadExcel
    test method olustur: readExcel()
    Dosyanin adresini String olarak bir konteynira koy
    dosyayi ac
    fileinputstream kullanarak workbook'u ac
    ilk worksheet'i ac
    ilk row'a git
    ilk row'daki ilk cell'e git ve yazdir
    ilk row'daki ikinci cell'e git ve yazdir
    2nd row'daki ilk cell'e git ve datanin ABD'ye esit oldugunu assert e
    3rd row'daki 2nd cell-chain the row and cell
    row sayisini bul
    Kullanilan row sayisini bul
    Ulke ve baskent key-value ciftlerini map object olarak yazdir
    */

    //not=sheet=sayfa, Row=satir, cell=hucre demektir
        @Test
    public void readExcel() throws IOException {

        //Dosyanin adresini String olarak bir konteynera koy

            String path="./src/test/java/resources/Baskent.xlsx";

            //dosyayi ac
            FileInputStream fileInputStream=new FileInputStream(path);

            //fileinputstream kullanarak workbook'u ac

          Workbook workbook= WorkbookFactory.create(fileInputStream);

          //ilk worksheet'i ac

          Sheet sheet= workbook.getSheetAt(0); //sheet sayfalari 0. indeksten baslar

            //ilk row'a git

         Row ilkRow = sheet.getRow(0);//rowlarda index 0 dan baslar

            //ilk row'daki ilk cell'e git ve yazdir

            Cell ilkCell= ilkRow.getCell(0);//cell idexi 0 dan baslar

            System.out.println(ilkCell);

          //2. row'daki ikinci cell'e git ve yazdir
            //1.yol
  //      Row row2=sheet.getRow(1);  //indeks kullandik
   //     Cell cell21=row2.getCell(1);
     //       System.out.println(cell21);

           //2.yol
          Cell row1Cell2 = sheet.getRow(0).getCell(1);
            System.out.println(row1Cell2);//Baskent

            // 2nd row'daki ilk cell'e git ve datanin ABD'ye esit oldugunu assert et

           Cell row2Cell1=sheet.getRow(1).getCell(0);
            System.out.println("Data ABD:" +row2Cell1);

           boolean esitMi=row2Cell1.toString().equals("ABD");
            Assert.assertTrue(esitMi);

           // 3rd row'daki 2nd cell-chain the row and cell

          Cell row3Cell2=sheet.getRow(2).getCell(1);
            System.out.println(row3Cell2);

          //row sayisini bul

          int rowSayisi=sheet.getLastRowNum()+1;
            System.out.println(rowSayisi);

          //Kullanilan row sayisini bul

          int kullanilanRowSayisi=sheet.getPhysicalNumberOfRows();
            System.out.println(kullanilanRowSayisi);

            // Ulke ve baskent key-value ciftlerini map object olarak yazdir
            //orn-->ulke=abd baskent=dc

            Map<String,String> dunyaBaskentleri=new HashMap<>();//HashMap siraya bakmaz
            int ulkeColumn=0;
            int baskentColumn=1;
            /*
            row numarasi 1den bsalar, cunki header 0. indextedir
            En somdaki row'un indeksi=lastRowNumber yada sheet.getLastRowNum()+1;
            ABD= sheet.getRow(1). getCELL(0);
            Fransa=sheet.getRow(2).getCELL(0);
             */

            for(int rowNumuarasi=1; rowNumuarasi<rowSayisi; rowNumuarasi++) {

                String ulke = sheet.getRow(rowNumuarasi).getCell(ulkeColumn).toString();
                String baskent = sheet.getRow(rowNumuarasi).getCell(baskentColumn).toString();

                System.out.println("ulke" + ulke);
                System.out.println("baskent " + baskent);
                dunyaBaskentleri.put(ulke, baskent);//map'e ulke ve baskent ekledik

            }

            System.out.println(dunyaBaskentleri);//Map e ULKE VE BASKENT EKLEMIS OLDUK

        }

        @Test
    public void excelUtilDemo(){

            String path="./src/test/java/resources/Baskent.xlsx";

            String sheetNme="Sayfa1";

            //ExcelUtil classi kullanmak icin
            ExcelUtil excelUtil=new ExcelUtil(path, sheetNme);

            //Excel Utildeki methodlari calistirabiliriz
     System.out.println(excelUtil.getDataList());//[{Ulke=ABD, Baskent=DC}, {Ulke=Fransa, Baskent=Paris}, {Ulke=Ingiltere, Baskent=Londra}, {Ulke=Yunanistan, Baskent=Atina}, {Ulke=Kanada, Baskent=Ottowa}, {Ulke=Japonya, Baskent=Tokyo}, {Ulke=Norvec, Baskent=Oslo}, {Ulke=Almanya, Baskent=Berlin}, {Ulke=Italya, Baskent=Roma}, {Ulke=Turkiye, Baskent=Ankara}]

            System.out.println(excelUtil.columnCount());//2
            System.out.println(excelUtil.rowCount());//11
            System.out.println(excelUtil.getCellData(5,1));//Ottowa
            System.out.println(excelUtil.getColumnsNames());//[ulke, baskent]


        }

}
