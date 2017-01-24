package com.wbl.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.page.HomePage;
import com.wbl.page.LoginPage;

import junit.framework.Assert;

public class HomePageTest extends BaseTest {
	
	HomePage hm;
	
	@BeforeClass
	public void before(){
		hm = new HomePage(driver);
	}
	
	@Test
	public void testNavLinks(){
		Assert.assertEquals(5,hm.headerNavLinks());
	}
	
	@Test
	public void testSearchBox(){
		Assert.assertEquals("hp laptop - Walmart.com",hm.searchBox());
	}
	
	@Test
	public void testSignInLink(){
		LoginPage lp = hm.clickSignIn();
		Assert.assertEquals("Login", lp.getTitle());
	}
	
	//to-do - test methods for other 3 in homepage

}
