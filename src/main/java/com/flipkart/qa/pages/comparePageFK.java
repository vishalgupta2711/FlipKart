package com.flipkart.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.qa.base.TestBaseFK;

public class comparePageFK extends TestBaseFK{

	//Page Factory
	//Brand button dropdown
	@FindBy(css = "#fk-compare-page > div > div > div > div._1SVp3c > div._1k1axX._1DLH7w > div > div.col-3-5 > div:nth-child(1) > div > div:nth-child(2)")
	static WebElement chooseABrandBtn;
	
	@FindBy(css="#fk-compare-page > div > div > div > div._1SVp3c > div._1k1axX._1DLH7w > div > div.col-3-5 > div:nth-child(1) > div > div:nth-child(3) > div._3092M2.LykW5d")
	static WebElement chooseAProductBtn;
	
	String chooseBrandDDElements = "#fk-compare-page > div > div > div > div._1SVp3c > div._1k1axX._1DLH7w > div > div.col-3-5 > div:nth-child(1) > div > div:nth-child(2) > div.LG4KV_ > div>div";
	String chooseBrandDDValue = "Samsung";
	
	String chooseAProductDDElements ="#fk-compare-page > div > div > div > div._1SVp3c > div._1k1axX._1DLH7w > div > div.col-3-5 > div:nth-child(1) > div > div:nth-child(3) > div.LG4KV_ > div>div";
	String chooseAProductDDValue = "Samsung Galaxy A31";
	
	public comparePageFK() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void dropDownElements() {
		//chooseABrandBtn.click();
		new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(chooseABrandBtn)).click();
		dropDownElementsBrandHelperClass(chooseBrandDDElements,chooseBrandDDValue);
		
		//chooseAProductBtn.click();
		new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(chooseAProductBtn)).click();
		dropDownElementsProductHelperClass(chooseAProductDDElements,chooseAProductDDValue);
	}
	
	//Below function is for selecting brand dd value
	public void dropDownElementsBrandHelperClass(String chooseBrandDDElements , String chooseBrandDDValue) {
		
		//below line prints no of elements in the chooseBrandBtn dropdown.
		List <WebElement> list = driver.findElements(By.cssSelector(chooseBrandDDElements));
		//List <WebElement> list = driver.findElements(By.xpath("//*[@id=\"fk-compare-page\"]/div/div/div/div[1]/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/div//div"));

		System.out.println(list.size());

		for(int i=0 ; i<list.size() ; i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals(chooseBrandDDValue)) {
				list.get(i).click();
				break;
			}
		}
	}
	
	//Below function is for selecting product dd value
	public void dropDownElementsProductHelperClass(String chooseAProductDDElements , String chooseAProductDDValue) {

		//below line prints no of elements in the chooseProductBtn dropdown.
		List <WebElement> list = driver.findElements(By.cssSelector(chooseAProductDDElements));
		System.out.println(list.size());

		for(int i=0 ; i<list.size() ; i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains(chooseAProductDDValue)) {
				list.get(i).click();
				break;
			}
		}
	}
	public static void clickElementByJSSearchPage(WebDriver driver,WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
	}
}
