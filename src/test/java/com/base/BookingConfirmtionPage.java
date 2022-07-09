package com.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmtionPage extends BaseClass {
	public BookingConfirmtionPage() {
		PageFactory.initElements(driver, this);
	}
@FindBy(id="order_no")
private WebElement orderNo;

@FindBy(xpath="//td[@class=\"login_title\"]")
private WebElement confirmationMessage;

public WebElement getOrderNo() {
	return orderNo;
}

public WebElement getConfirmationMessage() {
	return confirmationMessage;
}
public String bookingConfirmation() {
	String orderNum= getAttribute(getOrderNo());
	return orderNum;
}
}