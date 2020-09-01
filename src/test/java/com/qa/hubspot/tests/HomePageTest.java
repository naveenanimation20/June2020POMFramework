package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

public class HomePageTest extends BaseTest {
	
	@BeforeClass
	public void homePageSetup() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("home page title is : " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void verifyHomePageHeaderTest() {
		String header = homePage.getHeaderValue();
		System.out.println("home page header is : " + header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
	}

	@Test(priority = 3)
	public void verifyAccountTest() {
		String account = homePage.getAccountName();
		System.out.println("account name is : " + account);
		Assert.assertEquals(account, prop.getProperty("accountname").trim());
	}

	@Test(priority = 4)
	public void verifySettingsIconTest() {
		Assert.assertTrue(homePage.isSettingsIconExist());
	}

}
