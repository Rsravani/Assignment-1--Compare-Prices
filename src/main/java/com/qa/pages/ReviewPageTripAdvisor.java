package com.qa.pages;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPageTripAdvisor extends TestBase
{

    @FindBy(xpath = "//a[contains(text(),'Write a review')]")
    WebElement writeAReviewBtn;

    @FindBy(xpath = "//input[@id='ReviewTitle']")
    WebElement reviewTitleInput;

    @FindBy(xpath = "//textarea[@id='ReviewText']")
    WebElement reviewTextInput;

    @FindBy(xpath = "//span[contains(text(),'Submit your review')]")
    WebElement submitRvwBtn;

    //todo -------------
    @FindBy(xpath = "//span[@class='ui_bubble_rating fl bubble_00']")
    WebElement starPath;



    public ReviewPageTripAdvisor() {
        PageFactory.initElements(driver, this);
    }

    public void giveReview(String title, String desc) throws InterruptedException
    {


        //switch to tab which is newly opened tab
        TestUtil.switchTab();


        //Scroll till review button
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", writeAReviewBtn);
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-100)");

        //click on write review button and switch to respective tab
        Thread.sleep(1000);
        writeAReviewBtn.click();
        Thread.sleep(3000);
        TestUtil.switchTab();

        //Todo Mouse hover and give 5 start rating
        //searchBox.click();
        TestUtil.mouseHoverOnElement(starPath);
        starPath.click();
        //Enter Review title
        reviewTitleInput.sendKeys(title);

        //Enter Review body
        reviewTextInput.sendKeys(desc);


        //Todo give 5 star rating for Hotel Ratings
        //searchBox.click();

        //Submit your review
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitRvwBtn);
        Thread.sleep(1000);
        submitRvwBtn.click();


    }
}
