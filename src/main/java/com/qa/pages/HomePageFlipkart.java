package com.qa.pages;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFlipkart extends TestBase {

    @FindBy(xpath = "//input[@placeholder='Search for products, brands and more']")
    WebElement searchBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchIcon;

    @FindBy(xpath = "(//div[contains(text(),'Apple iPhone XR (Yellow, 64 GB)')]//..//..//div[@class='_1vC4OE _2rQ-NK'])[1]")
    WebElement firstProductPrice;

    @FindBy(xpath = "//button[@class='_2AkmmA _29YdH8']")
    WebElement loginPopUp;


    // Initializing the Page Objects:
    public HomePageFlipkart() {
        PageFactory.initElements(driver, this);
    }

    public int searchForProductAndGetPrice(String productName){

        //close the login pop up
        //loginPopUp.click();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", loginPopUp);

        //enter the product name in text box
        searchBox.sendKeys(productName);

        //click on search icon
        searchIcon.click();

        //first product price
        String priceString  = firstProductPrice.getText();
        int priceNumber = TestUtil.convertPriceToNumber(priceString);
        return priceNumber;
    }
}
