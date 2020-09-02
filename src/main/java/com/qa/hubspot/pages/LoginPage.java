package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	private WebDriver driver;
	ElementUtil elementUtil;

	// By Locators - OR
	private By emailId = By.id("username");
	private By password = By.id("password");
	private By loginButton = By.id("loginBtn");
	private By signUpLink = By.linkText("Sign up");

	// Constructor of the page:
	public LoginPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}

	// Page Actions:
	@Step("getting login page title")
	public String getLoginPageTitle() {
		return elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}

	@Step("getting sign up link exist on login page")
	public boolean isSignUpLinkExist() {
		return elementUtil.doIsDisplayed(signUpLink);
	}

	@Step("user login with username : {0} and password : {1}")
	public HomePage doLogin(String un, String pwd) {
		System.out.println("login to app....");
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);

		return new HomePage(driver);
	}

}
