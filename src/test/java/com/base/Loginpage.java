package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends BaseClass {

	public Loginpage() {
		PageFactory.initElements(driver, this);
	}


	@FindBy(id = "username")
	private WebElement txtUserName;

	@FindBy(name = "password")
	private WebElement txtpassword;

	@FindBy(id = "login")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//b[contains(text(),'Invalid Login details or Your Password might have expired.')]")
	private WebElement errorMessage;

	@FindBy(id = "username_show")
	private WebElement titleUser;
	
	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public void setTxtUserName(WebElement txtUserName) {
		this.txtUserName = txtUserName;
	}

	public WebElement getTxtpassword() {
		return txtpassword;
	}

	public void setTxtpassword(WebElement txtpassword) {
		this.txtpassword = txtpassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(WebElement btnLogin) {
		this.btnLogin = btnLogin;
	}
    
	public WebElement getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(WebElement errorMessage) {
		this.errorMessage = errorMessage;
	}

	public WebElement getTitleUser() {
		return titleUser;
	}

	public void setTitleUser(WebElement titleUser) {
		this.titleUser = titleUser;
	}

	public void login(String userName,String password) {
		sendData(getTxtUserName(),userName);
		sendData(getTxtpassword(),password);
		click(getBtnLogin());
	}
	public void loginWithEnter(String userName,String password) throws AWTException {

		sendData(getTxtUserName(),userName);
		sendData(getTxtpassword(),password);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);	
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
  
	}
	
	
	
	
	
	
	
	
}