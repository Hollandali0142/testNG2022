package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Day09_C1_TestNGAnnotations {

    /*
    @Test test caseleri olusturmak icin kullanilir TestNG
    @BeforeMEthod her bir @Test anotationdan sonra kosmasi icin kullanilir
    @AfterMethod herbir @Test anotationdan sonra kosmasi icin kullaniriz
    @Ignore bir @Test anotation- atlamak icin kullanilir
    @Test(enabled=false) durumunda  @Test anotation- atlamak icin kullaniriz--ignore gibidir

    Test caseleri siralayabiliriz
    TestNG test caseleri alfabetik siraya gore kosturur- yukaridan asagiya gore calistirmaz
    Test case icin priority kullanarak siralama yapariz

     */

    @BeforeMethod
    public void setUp() {
        System.out.println("before method kullandik");

    }

    @AfterMethod
    public void teaDown() {
        System.out.println("After method kullandik");

    }

    @Test(priority = 2, groups = "tet-group-1")
    public void test6(){
        System.out.println("Test 6");

    }


    @Test(enabled = false)
    public void test2(){

        System.out.println("Test 2");

    }

    @Ignore
        @Test

        public void test3 () {
            System.out.println("Test 3");

        }

        @Test

        public void test4 () {
            System.out.println("Test 4");

        }

        @Test

        public void test5 () {
            System.out.println("Test 5");

        }

    @Test(priority = 1,groups = "tet-group-1")

    public void test7 () {
        System.out.println("Test 7");

    }

}