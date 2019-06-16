package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewPage {
	@FindBy(xpath = "//*[@id=\"theInput\"]")
	private WebElement trick;

	@FindBy(xpath = "//*[@id=\"trickName\"]")
	private WebElement result;

	public void searchTrick(String theTrick) {
		trick.sendKeys(theTrick);

	}

	public String getTrick() {
		return result.getText();
	}

}
