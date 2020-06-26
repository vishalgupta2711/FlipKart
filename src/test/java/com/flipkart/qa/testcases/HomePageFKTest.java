package com.flipkart.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBaseFK;
import com.flipkart.qa.pages.HomePageFK;

public class HomePageFKTest extends TestBaseFK{
	
	HomePageFK homePageFK;
	public HomePageFKTest(){
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
		homePageFK = new HomePageFK();
	}

	@Test
	public void verifyElectronicsSectionClick() {
		homePageFK.clickOnCloseBtn();
		homePageFK.hoverAndClickOnElectronics();
		homePageFK.clickOnSamsungNavBtn();
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("program reached HomePageFKTest");
		//driver.quit();
	}
}
