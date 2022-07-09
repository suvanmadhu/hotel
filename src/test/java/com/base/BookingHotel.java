package com.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock;

public class BookingHotel extends BaseClass {

	public BookingHotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="first_name")	
	private WebElement txtFirstName;

	@FindBy(id="last_name")
	private WebElement txtLastName;

	@FindBy(id="address")
	private WebElement txtAddrees;

	@FindBy(id="cc_num")
	private WebElement txtccNum;

	@FindBy(id="cc_type")
	private WebElement txtcctype;

	@FindBy(id="cc_exp_month")
	private WebElement txtccMonth;

	@FindBy(id="cc_exp_year")
	private WebElement txtYear;

	@FindBy(id="cc_cvv")
	private WebElement txtCvv;

	@FindBy(id="book_now")
	private WebElement clickbook;
	@FindBy(xpath = "//label[@id='first_name_span']")
	private WebElement fnErrMsg;
	@FindBy(xpath = "//label[@id='last_name_span']")
	private WebElement lnErrMsg;
	@FindBy(xpath = "//label[@id='address_span']")
	private WebElement addErrMsg;
	@FindBy(xpath = "//label[@id='cc_num_span']")
	private WebElement ccNoErrMsg;
	@FindBy(xpath = "//label[@id='cc_type_span']")
	private WebElement ccTypeErrMsg;
	@FindBy(xpath = "//label[@id='cc_expiry_span']")
	private WebElement ccExpErrMsg;
	@FindBy(id ="cc_cvv_span")
	private WebElement cvvErrMsg;


	public WebElement getFnErrMsg() {
		return fnErrMsg;
	}

	public WebElement getLnErrMsg() {
		return lnErrMsg;
	}

	public WebElement getAddErrMsg() {
		return addErrMsg;
	}

	public WebElement getCcNoErrMsg() {
		return ccNoErrMsg;
	}

	public WebElement getCcTypeErrMsg() {
		return ccTypeErrMsg;
	}

	public WebElement getCcExpErrMsg() {
		return ccExpErrMsg;
	}

	public WebElement getCvvErrMsg() {
		return cvvErrMsg;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public void setTxtFirstName(WebElement txtFirstName) {
		this.txtFirstName = txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public void setTxtLastName(WebElement txtLastName) {
		this.txtLastName = txtLastName;
	}

	public WebElement getTxtAddrees() {
		return txtAddrees;
	}

	public void setTxtAddrees(WebElement txtAddrees) {
		this.txtAddrees = txtAddrees;
	}

	public WebElement getTxtccNum() {
		return txtccNum;
	}

	public void setTxtccNum(WebElement txtccNum) {
		this.txtccNum = txtccNum;
	}

	public WebElement getTxtcctype() {
		return txtcctype;
	}

	public void setTxtcctype(WebElement txtcctype) {
		this.txtcctype = txtcctype;
	}

	public WebElement getTxtccMonth() {
		return txtccMonth;
	}

	public void setTxtccMonth(WebElement txtccMonth) {
		this.txtccMonth = txtccMonth;
	}

	public WebElement getTxtYear() {
		return txtYear;
	}

	public void setTxtYear(WebElement txtYear) {
		this.txtYear = txtYear;
	}

	public WebElement getTxtCvv() {
		return txtCvv;
	}

	public void setTxtCvv(WebElement txtCvv) {
		this.txtCvv = txtCvv;
	}

	public WebElement getClickbook() {
		return clickbook;
	}

	public void setClickbook(WebElement clickbook) {
		this.clickbook = clickbook;
	}
	public void bookHotel(String FirstName, String LastName,String Addrees,String ccNum, String txtcctype, String ccExp, String ccYear, String Cvv) {
		sendData(getTxtFirstName(), FirstName);
		sendData(getTxtLastName(), LastName);
		sendData(getTxtAddrees(), Addrees);
		sendData(getTxtccNum(), ccNum);
		selectByVisibleText(getTxtcctype(), txtcctype);
		selectByVisibleText(getTxtccMonth(), ccExp);
		selectByVisibleText(getTxtYear(), ccYear);
		sendData(getTxtCvv(), Cvv);
		click(getClickbook());
	}
	public void bookHotel() {
		click(getClickbook());
	}



}
