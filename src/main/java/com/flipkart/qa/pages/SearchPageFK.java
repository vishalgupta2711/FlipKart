package com.flipkart.qa.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBaseFK;

public class SearchPageFK extends TestBaseFK {
	
	//PageFactory - OR for searchPage
	
	@FindBy(xpath = "//input[@name = 'q']")
	static WebElement searchTxtField;
	
	@FindBy(css = "#container > div > div._3ybBIU > div._1tz-RS > div._3pNZKl > div.Y5-ZPI > form > div > button")
	static WebElement srchBtn;
	
	@FindBy(css = "div._1p7h2j")
	static WebElement compareCheckBox;
	
	@FindBy(css = "a._1h5zc_")
	WebElement CompareBtn;
	
	public SearchPageFK() {
		PageFactory.initElements(driver, this);
	}
	
	static String searchKeys = "Samsung Galaxy";
	static String phoneNameSelect = "Samsung Galaxy A50";
	
	//Actions
	
	public static void searchTextCall() {
		searchTextSpecificPhone(searchKeys);
		srchBtn.click();	
		selectPhone();
	}
	
	public static void searchTextSpecificPhone(String searchKeys) {
		searchTxtField.sendKeys(searchKeys);	
	}
	
	public static void selectPhone() {
		String beforeCss = "#container > div > div.t-0M7P._2doH3V > div._3e7xtJ > div._1HmYoV.hCUpcT > div:nth-child(2) > div:nth-child(";
		String afterCss = ") > div > div > div > a > div._1-2Iqu.row > div.col.col-7-12 > div._3wU53n";
		List<WebElement> rowNum = driver.findElements(By.cssSelector("#container > div > div.t-0M7P._2doH3V > div._3e7xtJ > div._1HmYoV.hCUpcT > div:nth-child(2) > div"));
		System.out.println(rowNum.size());
		
		for(int i=2 ; i<=rowNum.size() ; i++) {
			
			String phoneNames = driver.findElement(By.cssSelector(beforeCss+i+afterCss)).getText();
			System.out.println(phoneNames);
			if(phoneNames.contains(phoneNameSelect)) {
				driver.findElement(By.cssSelector(beforeCss+i+afterCss)).click();
				break;
			}
		}
		switchToWindow();
	}
	
	public static void switchToWindow() {
		Set <String> handler = driver.getWindowHandles();
		Iterator <String> it = handler.iterator();
		String parentWindowId = it.next();
		System.out.println("Parent window id : "+parentWindowId);
		String childWindowId = it.next();
		System.out.println("Child window id : "+childWindowId);
		driver.switchTo().window(childWindowId);
		
		clickElementByJSSearchPage(driver,compareCheckBox); // clicking on compare checkbox button

//		driver.findElement(By.cssSelector("button._2AkmmA._2Npkh4._2kuvG8._7UHT_c")).click(); // click on buy button
	}
	
	public comparePageFK clickOnCompareBtn() {
		CompareBtn.click();
		return new comparePageFK();
	}
	
	public static void clickElementByJSSearchPage(WebDriver driver,WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
	}
	
}
