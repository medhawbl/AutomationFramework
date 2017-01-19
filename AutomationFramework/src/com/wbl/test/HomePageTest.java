package com.wbl.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.page.HomePage;

import junit.framework.Assert;

public class HomePageTest extends BaseTest {
	
	HomePage hm;
	
	@BeforeClass
	public void before(){
		hm = new HomePage(driver);
		hm.navigateToHomePage();
	}
	
	@Test
	public void testNavLinks(){
		Assert.assertEquals(5,hm.headerNavLinks());
	}
	
	@Test
	public void testSearchBox(){
		//System.out.println(hm.searchBox());
		Assert.assertEquals("hp laptop - Walmart.com",hm.searchBox());
	}
	
	//to-do - test methods for other 3 in homepage

}
