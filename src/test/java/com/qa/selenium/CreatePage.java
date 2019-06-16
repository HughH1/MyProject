package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePage {
	
	@FindBy(xpath = "//*[@id=\"cTrickName\"]")
	private WebElement trick;
	
	@FindBy(xpath = "//*[@id=\"cDesc\"]")
	private WebElement desc;
	
	@FindBy(xpath = "//*[@id=\"cProgress\"]")
	private WebElement progress;
	
	@FindBy(xpath = "//*[@id=\"cDifficulty\"]")
	private WebElement difficulty; 
		
	
	public void inputs(String myTrick, String myDesc, String myProgress, String myDifficulty) {
		trick.sendKeys(myTrick);
		desc.sendKeys(myDesc);
		progress.sendKeys(myProgress);
		difficulty.sendKeys(myDifficulty);
		}
	
	
//				driver.switchTo().alert().getText();
	
}
