package com.qa.selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NavigationTesting {

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
	public void indexToCreate() {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/index.html");
		action.moveToElement(driver.findElement(By.xpath("/html/body/doctype/header/nav/li[1]/a"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		assertEquals("Change page failed", "http://35.234.153.117:8080/SkateTricks-1.0/create.html", url);
	}

	@Test
	public void indexToRead() {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/index.html");
		action.moveToElement(driver.findElement(By.xpath("//html/body/doctype/header/nav/li[2]/a"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		assertEquals("Read page failed", "http://35.234.153.117:8080/SkateTricks-1.0/view.html", url);
	}

	@Test
	public void indexToUpdate() {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/index.html");
		action.moveToElement(driver.findElement(By.xpath("/html/body/doctype/header/nav/li[3]/a"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		assertEquals("Change page failed", "http://35.234.153.117:8080/SkateTricks-1.0/update.html", url);
	}

	@Test
	public void indexToDelete() {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/index.html");
		action.moveToElement(driver.findElement(By.xpath("/html/body/doctype/header/nav/li[4]/a"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		assertEquals("Change page failed", "http://35.234.153.117:8080/SkateTricks-1.0/delete.html", url);
	}

	@Test
	public void createToUpdate() {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/create.html");
		action.moveToElement(driver.findElement(By.xpath("/html/body/doctype/header/nav/li[3]/a"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		assertEquals("Change page failed", "http://35.234.153.117:8080/SkateTricks-1.0/update.html", url);
	}

	@Test
	public void createToView() {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/create.html");
		action.moveToElement(driver.findElement(By.xpath("/html/body/doctype/header/nav/li[2]/a"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		assertEquals("Change page failed", "http://35.234.153.117:8080/SkateTricks-1.0/view.html", url);
	}

	@Test
	public void createToDelete() {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/update.html");
		action.moveToElement(driver.findElement(By.xpath("/html/body/doctype/header/nav/li[4]/a"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		assertEquals("Change page failed", "http://35.234.153.117:8080/SkateTricks-1.0/delete.html", url);
	}

	@Test
	public void updateToCreate() {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/update.html");
		action.moveToElement(driver.findElement(By.xpath("/html/body/doctype/header/nav/li[1]/a"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		assertEquals("Change page failed", "http://35.234.153.117:8080/SkateTricks-1.0/create.html", url);
	}

	@Test
	public void updateToToView() {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/update.html");
		action.moveToElement(driver.findElement(By.xpath("/html/body/doctype/header/nav/li[2]/a"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		assertEquals("Change page failed", "http://35.234.153.117:8080/SkateTricks-1.0/view.html", url);
	}

	@Test
	public void updateToDelete() {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/update.html");
		action.moveToElement(driver.findElement(By.xpath("/html/body/doctype/header/nav/li[4]/a"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		assertEquals("Change page failed", "http://35.234.153.117:8080/SkateTricks-1.0/delete.html", url);
	}

	@Test
	public void viewToCreate() {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/view.html");
		action.moveToElement(driver.findElement(By.xpath("/html/body/doctype/header/nav/li[1]/a"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		assertEquals("Change page failed", "http://35.234.153.117:8080/SkateTricks-1.0/create.html", url);
	}

	@Test
	public void viewToUpdate() {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/view.html");
		action.moveToElement(driver.findElement(By.xpath("/html/body/doctype/header/nav/li[3]/a"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		assertEquals("Change page failed", "http://35.234.153.117:8080/SkateTricks-1.0/update.html", url);
	}

	@Test
	public void viewToDelete() {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/view.html");
		action.moveToElement(driver.findElement(By.xpath("/html/body/doctype/header/nav/li[4]/a"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		assertEquals("Change page failed", "http://35.234.153.117:8080/SkateTricks-1.0/delete.html", url);
	}

	@Test
	public void deleteToCreate() {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/delete.html");
		action.moveToElement(driver.findElement(By.xpath("/html/body/doctype/header/nav/li[1]/a"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		assertEquals("Change page failed", "http://35.234.153.117:8080/SkateTricks-1.0/create.html", url);
	}

	@Test
	public void deleteToUpdate() {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/delete.html");
		action.moveToElement(driver.findElement(By.xpath("/html/body/doctype/header/nav/li[3]/a"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		assertEquals("Change page failed", "http://35.234.153.117:8080/SkateTricks-1.0/update.html", url);
	}

	@Test
	public void deleteToView() {
		driver.get("http://35.234.153.117:8080/SkateTricks-1.0/delete.html");
		action.moveToElement(driver.findElement(By.xpath("/html/body/doctype/header/nav/li[2]/a"))).click().perform();
		driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		assertEquals("Change page failed", "http://35.234.153.117:8080/SkateTricks-1.0/view.html", url);
	}
}
