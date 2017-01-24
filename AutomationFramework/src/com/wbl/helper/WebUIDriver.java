package com.wbl.helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebUIDriver {
	
	
	public static String browserName;
	public static String appUrl;
	
	public static void loadProperties(String fileName) throws FileNotFoundException, IOException{
		Properties prop = ConfigUtils.loadProperties(fileName);
		browserName = prop.getProperty("browser");
		appUrl= prop.getProperty("appUrl");
	}
	
	public static  WebDriver getDriver(){
		
		//returning reqd object based on input is factory pattern in java
		WebDriver driver;
		
		switch(browserName){
		case "firefox":
			System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir")+"\\resources\\firefoxdriver.exe");
			driver = new FirefoxDriver();
			break;
			
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "safari":
			System.setProperty("webdriver.safari.driver", System.getProperty("user.dir")+"\\resources\\safaridriver.exe");
			driver = new SafariDriver();
			break;
			
		case "ie":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\resources\\internetexplorerdriver.exe");
			driver = new InternetExplorerDriver();
			break;
			
		case "htmlunit":
			driver = new HtmlUnitDriver();
			break;
			
			default:
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
					
		}
	
		return driver;
		
	}

}
