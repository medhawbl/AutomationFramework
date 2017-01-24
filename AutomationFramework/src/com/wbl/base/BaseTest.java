package com.wbl.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.wbl.helper.ByClass;
import com.wbl.helper.WebUIDriver;


public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeSuite
	public void beforeSuite(){		
		try {
			WebUIDriver.loadProperties("config.properties");
		}  catch (IOException e) {
			e.printStackTrace();
		}
		driver = WebUIDriver.getDriver();
		driver.get(WebUIDriver.appUrl);
		ByClass.loadProperties();
	}
	
	
	@AfterSuite
	public void afterSuite(){
		driver.close();
	}

}
