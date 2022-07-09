package com.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelBookingPage extends BaseClass {
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}
     
	
	@FindBy(id = "order_no")
	private WebElement orderNo;
	
	@FindBy(xpath = "//a[text()=\"Booked Itinerary\"]")
	private WebElement btnMyItinerary;
	@FindBy(id = "order_id_text")
	private WebElement orderSearch;
	@FindBy(id = "search_hotel_id")
	private WebElement btnOrderSearch;
	@FindBy(id = "check_all")
	private WebElement checkAll;

	public WebElement getOrderNo() {
		return orderNo;
	}

	public WebElement getBtnMyItinerary() {
		return btnMyItinerary;
	}

	public WebElement getOrderSearch() {
		return orderSearch;
	}

	public WebElement getBtnOrderSearch() {
		return btnOrderSearch;
	}

	public WebElement getCheckAll() {
		return checkAll;
	}

	@FindBy(xpath = "//input[@value=\"Cancel Selected\"]")
	private WebElement cancelOrder;

	public WebElement getMyItinerary() {
		return btnMyItinerary;
	}

	public WebElement getOrderSearch1() {
		return orderSearch;
	}

	public WebElement getBtnOrderSearch1() {

		return btnOrderSearch;
	}

	public WebElement getCancelOrder() {
		return cancelOrder;
	}

	public void cancelBooking(String orderId) {
		click(getBtnMyItinerary());
		sendData(getBtnOrderSearch(), orderId);
		click(getBtnOrderSearch());
		click(getCheckAll());
		click(getCancelOrder());
		acceptAlert();
	}
	// public void CancelBooking() {
	//
	//
	// }

}