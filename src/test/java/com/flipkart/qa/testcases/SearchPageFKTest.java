package com.flipkart.qa.testcases;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBaseFK;
import com.flipkart.qa.pages.HomePageFK;
import com.flipkart.qa.pages.SearchPageFK;
import com.flipkart.qa.pages.comparePageFK;

public class SearchPageFKTest extends TestBaseFK {
	
	HomePageFK homePageFK;
	SearchPageFK searchPageFK;
	comparePageFK ComparePageFK;
	public SearchPageFKTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
		homePageFK = new HomePageFK();
		searchPageFK = new SearchPageFK();	
		ComparePageFK = new comparePageFK();
	}
	
	@Test(priority = 1)
	public void verifyClickOnCloseBtnTest() {
		homePageFK.clickOnCloseBtn();
	}
	
	@Test(priority = 2)
	public void verifyHoverAndClickOnElectronicsTest() {
		homePageFK.hoverAndClickOnElectronics();
	}
	
	@Test(priority = 3)
	public void verifyClickOnSamsungNavBtnTest() {
		searchPageFK = homePageFK.clickOnSamsungNavBtn();
	}
	
	@Test(priority = 4)
	public void verifySearchFunctionality() {
		try {
		SearchPageFK.searchTextCall();
		}
		catch(StaleElementReferenceException e) {
			SearchPageFK.searchTextCall();
		}
	}
	
	@Test(priority = 5)
	public void verifyCompareBtnClick() {
		ComparePageFK = searchPageFK.clickOnCompareBtn();
	}
	
	@Test(priority = 6)
	public void verifyComparePhones() {
		ComparePageFK.dropDownElements();
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("program reached till end");
		//driver.quit();
	}
}
