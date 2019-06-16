package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdatePage {

	@FindBy(xpath = "//*[@id=\"theInput\"]")
	private WebElement sTrick;

	@FindBy(xpath = "//*[@id=\"searchSubmit\"]")
	private WebElement submit;

	@FindBy(xpath = "//*[@id=\"uTrickName\"]")
	private WebElement trick;

	@FindBy(xpath = "//*[@id=\"uDesc\"]")
	private WebElement desc;

	@FindBy(xpath = "//*[@id=\"uProgress\"]")
	private WebElement progress;

	@FindBy(xpath = "//*[@id=\"uDifficulty\"]")
	private WebElement difficulty;

	@FindBy(xpath = "//*[@id=\"createSubmit\"]")
	private WebElement update;

	public void inputs(String myTrick, String myDesc, String myProgress, String myDifficulty) {
		trick.sendKeys(myTrick);
		desc.sendKeys(myDesc);
		progress.sendKeys(myProgress);
		difficulty.sendKeys(myDifficulty);
	}

	public void searchTrick(String theTrick) {
		sTrick.sendKeys(theTrick);
	}

}
