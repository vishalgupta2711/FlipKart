package com.flipkart.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.flipkart.qa.util.TestUtilFK;

public class TestBaseFK {

	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBaseFK(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("F:\\Vishal_Offc Work\\Workspace\\Flipkart\\src\\"
					+ "main\\java\\com\\flipkart\\qa\\config\\configFK.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver","F:\\Drivers\\geckodriver-v0.26.0-win64\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtilFK.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtilFK.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}

}
