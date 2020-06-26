package com.flipkart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBaseFK;

public class HomePageFK extends TestBaseFK {

	//PageFactory - OR for HomePage
	
	@FindBy(xpath = "//button[@class = '_2AkmmA _29YdH8']")
	WebElement closeBtn;
	
	@FindBy(xpath = "//span[@class='_1QZ6fC _3Lgyp8' and contains(text(),'Electronics')]")
	WebElement electronicsHover;
	
	@FindBy(xpath = "//span[@class='_1QZ6fC _3Lgyp8' and contains(text(),'Electronics')]/following-sibling::ul/descendant::a[contains(text(),'Samsung')]")
	WebElement samsungNavBtn;
	
	public HomePageFK() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	//driver.findElement(By.xpath("//button[@class = '_2AkmmA _29YdH8']"));//close button for first page login 
	
	public void clickOnCloseBtn() {
		clickElementByJS(driver, closeBtn);
	}
	
	public void hoverAndClickOnElectronics() {
		Actions action = new Actions(driver);
		action.moveToElement(electronicsHover).build().perform();
	}
	
	public SearchPageFK clickOnSamsungNavBtn() {
		clickElementByJS(driver,samsungNavBtn);
		return new SearchPageFK();
	}
	
	public static void clickElementByJS(WebDriver driver , WebElement element) {
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element );
	}
	
}
