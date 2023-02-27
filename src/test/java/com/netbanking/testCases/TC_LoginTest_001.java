package com.netbanking.testCases;

import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.netbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);
		
		logger.info("Url is opened");
		
		LoginPage lp = new LoginPage(driver);
	    logger.info("Enter Username");
		lp.setUserName(username);
		logger.info("Enter Password");
		lp.setPassword(password);
		lp.clickLogin();
		System.out.println(driver.getTitle());
		Thread.sleep(10);
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info(" login test is passed");
		}
		else {
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("login test is failed");
		}
		
	}
		
}
