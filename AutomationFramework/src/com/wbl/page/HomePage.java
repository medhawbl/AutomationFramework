package com.wbl.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class HomePage {
	
	WebDriver driver;

	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public void navigateToHomePage(){
		driver.get("https://www.walmart.com/");
	}
	
	public int headerNavLinks(){
		List<WebElement> elements =driver.findElements(By.cssSelector("[class*='header-GlobalEyebrowNav-link']"));
		return elements.size();
	}
	
	public String searchBox(){
		driver.findElement(By.xpath("//*[@placeholder='Search']")).sendKeys("Laptop");		

		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		String result = wait.until(function);
		return result;
	}
	
	
	
	Function<WebDriver,String> function = new Function<WebDriver, String>() {

		public String apply(WebDriver arg0) {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".header-Typeahead-row")));
			for(WebElement elm: elements){
				if(elm.getText().equalsIgnoreCase("hp laptop")){
					elm.click();
					break;
				}
				
			}

			return driver.getTitle();
		}
	};
	
	
	public String clickSignIn(){
		WebElement elm = driver.findElement(By.xpath(".//button[text()='My Account']"));
		Actions action = new Actions(driver);
		action.moveToElement(elm).perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		elm=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign In")));
		elm.click();
		return driver.getTitle();
	}
	
	public String clickCreateAccount(){
		WebElement elm = driver.findElement(By.xpath(".//button[text()='My Account']"));
		Actions action = new Actions(driver);
		action.moveToElement(elm).perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		elm=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[contains(text(),'Create an')]")));
		elm.click();
		return driver.getCurrentUrl();
	}
	

}
