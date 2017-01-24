package com.wbl.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver){
		this.driver = driver;
	}
	

	public String getTitle(){
		return driver.getTitle();
	}
	
	public String register(String firstname,String lastname,String email, String pwd){
		List<WebElement> elements = driver.findElements(By.cssSelector(".form-control"));
		elements.get(0).sendKeys(firstname);
		elements.get(1).sendKeys(lastname);
		elements.get(2).sendKeys(email);
		elements.get(3).sendKeys(pwd);
		elements.get(4).sendKeys(pwd);
		
		driver.findElement(By.xpath("//*[text()='Create Account']")).click();
		return driver.getTitle();
	}

}
