package com.wbl.helper;

import java.io.FileInputStream;
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
	
	
	static String browserName;
	
	public static void loadProperties(String fileName) throws FileNotFoundException, IOException{
		Properties prop = new Properties();
		prop.load(new FileInputStream( System.getProperty("user.dir")+"\\resources\\"+fileName));
		browserName = prop.getProperty("browser");
	}
	
	public static  WebDriver getDriver(){
		WebDriver driver = null;
		
		switch(browserName){
		case "firefox":
			System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir")+"\\resources\\firefoxdriver.exe");
			driver = new FirefoxDriver();
			
			
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			
		case "safari":
			System.setProperty("webdriver.safari.driver", System.getProperty("user.dir")+"\\resources\\safaridriver.exe");
			driver = new SafariDriver();
			
			
		case "ie":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\resources\\internetexplorerdriver.exe");
			driver = new InternetExplorerDriver();
			
			
		case "htmlunit":
			driver = new HtmlUnitDriver();
		}
	
		return driver;
		
	}

}
