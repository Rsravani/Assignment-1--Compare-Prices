package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageTripAdvisor extends TestBase
{

    @FindBy(xpath = "//span[@class='brand-global-nav-action-search-Search__label--3PRUD']")
    WebElement searchBox;

    @FindBy(xpath = "//input[@id='mainSearch']")
    WebElement searchBoxForInput;

    @FindBy(xpath = "//button[@id='SEARCH_BUTTON']")
    WebElement searchBtn;

    @FindBy(xpath = "(//span[contains(text(),'Club Mahindra')])[2]")
    WebElement firstResult;


    public HomePageTripAdvisor() {
        PageFactory.initElements(driver, this);
    }

    public ReviewPageTripAdvisor searchForProductAndGetPrice(String hotelName) throws InterruptedException{

        //click on search icon
        searchBox.click();

        //enter the HOTEL name in text box and click on search button
        searchBoxForInput.sendKeys(hotelName);
        searchBtn.click();

        //select the first result that appears in the list.
        firstResult.click();

        return  new ReviewPageTripAdvisor();
    }

}
