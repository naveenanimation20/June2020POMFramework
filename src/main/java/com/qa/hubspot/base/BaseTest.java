package com.qa.hubspot.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class BaseTest {

	WebDriver driver;
	public Properties prop;
	public BasePage basePage;
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;


	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browserName) {
		System.out.println("browserName is : "+ browserName);
		basePage = new BasePage();
		prop = basePage.init_prop();
		prop.setProperty("browser", browserName);
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
	}

	@AfterTest(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}

}
