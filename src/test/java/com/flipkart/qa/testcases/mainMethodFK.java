package com.flipkart.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mainMethodFK {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		
		
		WebElement closeBtn = driver.findElement(By.xpath("//button[@class = '_2AkmmA _29YdH8']"));//close button for first page login 
		clickElementByJS(driver, closeBtn);
		action.moveToElement(driver.findElement(By.xpath("//span[@class='_1QZ6fC _3Lgyp8' and contains(text(),'Electronics')]"))).build().perform();
		
		WebElement samsungNavBtn = driver.findElement(By.xpath("//span[@class='_1QZ6fC _3Lgyp8' and contains(text(),'Electronics')]/following-sibling::ul/descendant::a[contains(text(),'Samsung')]"));
		clickElementByJS(driver,samsungNavBtn);
	}
	
	public static void clickElementByJS(WebDriver driver , WebElement element) {
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element );
	}

}
