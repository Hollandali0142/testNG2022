package com.tests;

import com.utilities.ConfigReader;
import com.utilities.Driver;
import junit.framework.Assert;
import org.testng.annotations.Test;

public class Day09_C5_FirstConfigTest {

    //   app_url  'e git
    //   Title'in' Caretta Hotel - Home oldugunu assert e

        @Test
    public void firstConfigTest() throws InterruptedException {
      //   Driver.getDriver().get("http://www.carettahotel.com/");
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        Thread.sleep(5000);

      //   Title'in' Caretta Hotel - Home oldugunu assert e

          String actualTitle=Driver.getDriver().getTitle();
          String expectedtitle=ConfigReader.getProperty("app_title");
            Assert.assertEquals(actualTitle,expectedtitle);

        }

}
