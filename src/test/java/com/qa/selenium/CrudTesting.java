package com.qa.selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.qa.model.Trick;
import com.qa.repository.TrickDB;

import org.junit.runners.MethodSorters;

public class CrudTesting {

	WebDriver driver;

	Actions action;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Daniel Little/chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void create() throws InterruptedException {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/create.html");
		CreatePage createPage = PageFactory.initElements(driver, CreatePage.class);
		createPage.inputs("kickflip", "do the trick", "6", "3");
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"createSubmit\"]"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		Thread.sleep(100);
		String confirmed = driver.switchTo().alert().getText();
		assertEquals("Create test failed", "Trick has been created", confirmed);
	}

	@Test
	public void read() throws InterruptedException {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/view.html");
		ViewPage viewPage = PageFactory.initElements(driver, ViewPage.class);
		viewPage.searchTrick("shuvit");
		Thread.sleep(100);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"searchSubmit\"]"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		String result = viewPage.getTrick();
		assertEquals("View test failed", "shuvit", result);
	}

	@Test
	public void update() throws InterruptedException {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/update.html");
		UpdatePage updatePage = PageFactory.initElements(driver, UpdatePage.class);
		updatePage.searchTrick("kickflip");
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"searchSubmit\"]"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		Thread.sleep(100);
		updatePage.inputs("", "", "", "");
		updatePage.inputs("kickflip2", "new description", "4", "6");
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"createSubmit\"]"))).click().perform();
		String confirmed = driver.switchTo().alert().getText();
		assertEquals("Update test failed", "Trick has been updated", confirmed);
	}

	@Test
	public void delete() throws InterruptedException {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/delete.html");
		DeletePage deletePage = PageFactory.initElements(driver, DeletePage.class);
		deletePage.searchTrick("nollie");
		Thread.sleep(100);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"searchSubmit\"]"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"deleteSubmit\"]"))).click().perform();
		Thread.sleep(100);
		String confirmed = driver.switchTo().alert().getText();
		assertEquals("Delete test failed", "Trick has been deleted", confirmed);
	}

}
