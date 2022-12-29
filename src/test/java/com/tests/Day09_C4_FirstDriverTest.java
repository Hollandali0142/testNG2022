package com.tests;

import com.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09_C4_FirstDriverTest {

       /*
       Amazona git
       title'in 'Amazonu'u icerdigini verify et-
       Driver class calistigini check et
        */

        @Test
    public void amazontitkeTest(){
            //Amazona git
            Driver.getDriver().get("https://www.amazon.com");

            //title'in  'Amazonu'u icerdigini verify et-

          String actuelTitle = Driver.getDriver().getTitle();

        // Driver class calistigini check et

            Assert.assertTrue(actuelTitle.contains("Amazon"));


            Driver.closeDriver();
        }

}
