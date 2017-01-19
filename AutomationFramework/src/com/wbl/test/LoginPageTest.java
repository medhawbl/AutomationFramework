package com.wbl.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.page.HomePage;
import com.wbl.page.LoginPage;

public class LoginPageTest extends BaseTest{

	LoginPage lp;
	HomePage hm;
	
	@BeforeClass
	public void before(){
		lp = new LoginPage(driver);
		hm.navigateToHomePage();
		hm.clickSignIn();
	}
	
	@Test
	public void testLogin(){
		Assert.assertNotNull(lp.login("a@a.com", "test123"));
	}
	
	//to-do- any other functionslaity of login
}
