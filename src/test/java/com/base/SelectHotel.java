package com.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectHotel extends BaseClass{
	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//td[@class='login_title'])[2]")
	private WebElement titleMsg;
	
	@FindBy(id="radiobutton_span")
	private WebElement selectHotelverifyErr;

	@FindBy(id="radiobutton_0")
	private WebElement selectHotel;
	
	@FindBy(id="continue")
	private WebElement btnContinue;



	public WebElement getTitleMsg() {
		return titleMsg;
	}

	public WebElement getSelectHotelverifyErr() {
		return selectHotelverifyErr;
	}
	

	public WebElement getSelectHotel() {
		return selectHotel;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public void selectHotel() {
	click(getSelectHotel());
	click(getBtnContinue());
}
	public void WithoutSelectHotel() {
		click(getBtnContinue());
	}







}

