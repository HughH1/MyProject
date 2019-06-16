package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeletePage {
	@FindBy(xpath = "//*[@id=\"theInput\"]")
	private WebElement trick;

	@FindBy(xpath = "//*[@id=\"searchSubmit\"]")
	private WebElement result;
	
	@FindBy(xpath = "//*[@id=\"deleteSubmit\"]")
	private WebElement delete;
	
	
	public void searchTrick(String theTrick) {
		trick.sendKeys(theTrick);
	}
	
	
}
