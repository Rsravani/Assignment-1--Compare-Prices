package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.HomePageAmazon;
import com.qa.pages.HomePageFlipkart;
import com.qa.pages.HomePageTripAdvisor;
import com.qa.pages.ReviewPageTripAdvisor;
import com.qa.util.Constants;
import com.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TripAdvisorRatingTest extends TestBase {

    HomePageTripAdvisor homePageTripAdvisor;
    ReviewPageTripAdvisor reviewPageTripAdvisor;

    public TripAdvisorRatingTest(){
        super();
    }


    @BeforeMethod
    public void setUp()
    {
    initialization("tripadvisor");
    homePageTripAdvisor = new HomePageTripAdvisor();
    }

    @Test(priority=1)
    public void giveRatingToClubMahindra() throws  Exception{

        reviewPageTripAdvisor =  homePageTripAdvisor.searchForProductAndGetPrice(Constants.HOTEL_NAME);
        reviewPageTripAdvisor.giveReview(Constants.REVIEW_TITLE, Constants.REVIEW_DESC);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }





}