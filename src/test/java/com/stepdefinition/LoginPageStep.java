package com.stepdefinition;

import java.awt.AWTException;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the Adactin Home Page")
	public void user_is_on_the_Adactin_Home_Page() throws FileNotFoundException, IOException {

		browse(getPropertyFileInputValue("browserType"), getPropertyFileInputValue("url"));

	}

	@When("User Should Perform Login {string},{string}")
	public void user_Should_Perform_Login(String username, String password) {

		pom.getLoginPage().login(username, password);

	}

	@When("User Should Perform Login {string},{string} With Help of ENTER key")
	public void user_Should_Perform_Login_With_Help_of_ENTER_key(String username, String password) throws AWTException {
		pom.getLoginPage().loginWithEnter(username, password);

	}

	@Then("User Should Verify Login Error Message Contains After Login {string}")
	public void user_Should_Verify_Login_Error_Message_Contains_After_Login(String expected) {
		String text = getText(pom.getLoginPage().getErrorMessage());
		Assert.assertTrue("verify Error Message",text.contains(expected));
		
	}

}
