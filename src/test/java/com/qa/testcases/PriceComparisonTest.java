package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.HomePageAmazon;
import com.qa.pages.HomePageFlipkart;
import com.qa.util.Constants;
import com.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class PriceComparisonTest extends TestBase {

    HomePageAmazon homePageAmazon;
    HomePageFlipkart homePageFlipkart;
    int amazonPrice,flipkartPrice;

    public PriceComparisonTest(){
        super();
    }

    @Test(priority=1)
    public void getAmazonPrice() throws  Exception{

        initialization("amazon");
        homePageAmazon = new HomePageAmazon();

        Thread.sleep(2000);
        amazonPrice = homePageAmazon.searchForProductAndGetPrice(Constants.PRODUCT);
        System.out.println("Iphone XR Price on Amazon is :  " + amazonPrice);
        driver.close();

    }

    @Test(priority=2)
    public void getFlipkartPrice(){

        initialization("flipkart");
        homePageFlipkart = new HomePageFlipkart();

        flipkartPrice = homePageFlipkart.searchForProductAndGetPrice(Constants.PRODUCT);
        System.out.println(" Iphone XR Price on Flipkart is :  " + flipkartPrice);

    }

    @Test(priority=3)
    public void printTheResult(){
        String website = TestUtil.compareThePrices(amazonPrice,flipkartPrice);
        System.out.println("************* "+Constants.PRODUCT+" is cheaper on "+website.toUpperCase()+" *************");
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }





}