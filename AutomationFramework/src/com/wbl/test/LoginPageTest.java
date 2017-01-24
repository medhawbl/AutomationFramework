package com.wbl.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.helper.ExcelHelper;
import com.wbl.page.HomePage;
import com.wbl.page.LoginPage;

public class LoginPageTest extends BaseTest{

	LoginPage lp;
	HomePage hm;
	
	Logger logger = LogManager.getLogger(LoginPageTest.class);
	
	@BeforeClass
	public void before(){
		hm = new HomePage(driver);
		lp = hm.clickSignIn();
		
	}
	
	
	@DataProvider(name="logindata")
	public Object[][] testData(){		
		Object[][] data = ExcelHelper.getData("\\test-data\\login-testdata.xlsx");
		return data;
	}
	
	@Test(dataProvider="logindata")
	public void testLogin(String uname,String pwd){
		logger.info("In test login method...");
		try {
			Assert.assertNotNull(lp.login(uname,pwd));
		} catch (InterruptedException e) {
			logger.error("exception in login screen");
			e.printStackTrace();
		}
	}
	
	//to-do- any other functionslaity of login
}
