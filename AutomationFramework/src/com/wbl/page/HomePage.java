package com.wbl.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.wbl.helper.ByClass;

public class HomePage {
	
	WebDriver driver;
	

	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	
	public int headerNavLinks(){
		List<WebElement> elements =driver.findElements(ByClass.getByObject("css-navLocator"));
		return elements.size();
	}
	
	public String searchBox(){
		driver.findElement(ByClass.getByObject("xpath-searchBoxLocator")).sendKeys("Laptop");	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		String result = wait.until(function);
		return result;
	}
	
	
	
	Function<WebDriver,String> function = new Function<WebDriver, String>() {

		public String apply(WebDriver arg0) {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ByClass.getByObject("css-autoSearchLocator")));
			for(WebElement elm: elements){
				if(elm.getText().equalsIgnoreCase("hp laptop")){
					elm.click();
					break;
				}
				
			}

			return driver.getTitle();
		}
	};
	
	
	public LoginPage clickSignIn(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement elm = wait.until(ExpectedConditions.visibilityOfElementLocated(ByClass.getByObject("xpath-signInAndCreateAccountLocator")));
		Actions action = new Actions(driver);
		action.moveToElement(elm).perform();
		
		
		elm=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign In")));
		elm.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage clickCreateAccount(){
		WebElement elm = driver.findElement(ByClass.getByObject("xpath-signInAndCreateAccountLocator"));
		Actions action = new Actions(driver);
		action.moveToElement(elm).perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		elm=wait.until(ExpectedConditions.visibilityOfElementLocated(ByClass.getByObject("xpath-createAccountLocator")));
		elm.click();
		return new RegisterPage(driver);
	}
	

}
