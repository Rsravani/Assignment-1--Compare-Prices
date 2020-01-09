package com.qa.util;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 90;
	public static long IMPLICIT_WAIT = 25;

	public static int convertPriceToNumber ( String num)
	{
		String numArray[] = num.split("");
		String finalNumber="" ;

		for (String number : numArray)
		{

			 if (returnIfItIsANumber(number))
			 {
				 finalNumber = finalNumber+number;
			 }
		}

		return Integer.parseInt(finalNumber);
	}

	public static String compareThePrices ( int num1, int num2)
	{
		if (num1>num2)
		return "Flipkart";
		else return "Amazon";
	}

	public static boolean returnIfItIsANumber(String num)
	{
		try {
			int i = Integer.parseInt(num);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static void switchTab()
	{
		ArrayList<String> handles = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(handles.get(0));
		driver.close();
		driver.switchTo().window(handles.get(1));
	}


	public static void mouseHoverOnElement(WebElement webElement)
	{
		Actions action = new Actions(driver);
		action.moveToElement(webElement).build().perform();
	}


}
