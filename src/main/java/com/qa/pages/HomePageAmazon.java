package com.qa.pages;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageAmazon extends TestBase {

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement searchBox;

	@FindBy(xpath = "//input[@value='Go']")
	WebElement searchIcon;

	@FindBy(xpath = "(//span[@class='a-price-whole'])[1]")
	WebElement firstProductPrice;


	// Initializing the Page Objects:
	public HomePageAmazon() {
		PageFactory.initElements(driver, this);
	}

	public int searchForProductAndGetPrice(String productName){

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
