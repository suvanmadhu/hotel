package com.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Sleeper;

public class SearchHotelPage extends BaseClass {
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "location")
	private WebElement txtLocation;

	@FindBy(id = "hotels")
	private WebElement txtHotels;

	@FindBy(id = "room_type")
	private WebElement txtRoomType;

	@FindBy(id = "room_nos")
	private WebElement txtRoomNos;

	@FindBy(id = "datepick_in")
	private WebElement txtDataPickin;

	@FindBy(id = "datepick_out")
	private WebElement txtDatePickout;

	@FindBy(id = "adult_room")
	private WebElement txtxAdult;

	@FindBy(id = "child_room")
	private WebElement txtChild;

	@FindBy(id = "Submit")
	private WebElement Submit;
	
	@FindBy(xpath = "//td[@class='login_title']")
	private WebElement msgTitle;	
	@FindBy(xpath = "//span[@id='checkin_span']")
	private WebElement indate;
	@FindBy(xpath = "//span[@id='checkout_span']")
	private WebElement outdate;
	@FindBy(id = "location_span")
	private WebElement errmsg;
	

	public WebElement getSubmit() {
		return Submit;
	}

	public WebElement getErrmsg() {
		return errmsg;
	}

	public WebElement getIndate() {
		return indate;
	}

	public WebElement getOutdate() {
		return outdate;
	}
	public WebElement getMsgTitle() {
		return msgTitle;
	}


	public WebElement getTxtLocation() {
		return txtLocation;
	}

	public void setTxtLocation(WebElement txtLocation) {
		this.txtLocation = txtLocation;
	}

	public WebElement getTxtHotels() {
		return txtHotels;
	}

	public void setTxtHotels(WebElement txtHotels) {
		this.txtHotels = txtHotels;
	}

	public WebElement getTxtRoomType() {
		return txtRoomType;
	}

	public void setTxtRoomType(WebElement txtRoomType) {
		this.txtRoomType = txtRoomType;
	}

	public WebElement getTxtRoomNos() {
		return txtRoomNos;
	}

	public void setTxtRoomNos(WebElement txtRoomNos) {
		this.txtRoomNos = txtRoomNos;
	}

	public WebElement getTxtDataPickin() {
		return txtDataPickin;
	}

	public void setTxtDataPickin(WebElement txtDataPickin) {
		this.txtDataPickin = txtDataPickin;
	}

	public WebElement getTxtDatePickout() {
		return txtDatePickout;
	}

	public void setTxtDatePickout(WebElement txtDatePickout) {
		this.txtDatePickout = txtDatePickout;
	}

	public WebElement getTxtxAdult() {
		return txtxAdult;
	}

	public void setTxtxAdult(WebElement txtxAdult) {
		this.txtxAdult = txtxAdult;
	}

	public WebElement getTxtChild() {
		return txtChild;
	}

	public void setTxtChild(WebElement txtChild) {
		this.txtChild = txtChild;
	}

	public WebElement getSearchBtn() {
		return Submit;
	}

	public void setSearchBtn(WebElement searchBtn) {
		this.Submit = searchBtn;
		
		
		
	}
	public void SearchHotel(String location,String hotels,String roomtype,String roomnos,String pickin,String pickout,String adultroom,String childroom) {
		
		selectByValue(getTxtLocation(), location);
		selectByValue(getTxtHotels(), hotels);
		selectByValue(getTxtRoomType(), roomtype);
		selectByValue(getTxtRoomNos(), roomnos); 
	
		clear(getTxtDataPickin());
	    sendData(getTxtDataPickin(), pickin);
	    
		clear(getTxtDatePickout());
		sendData(getTxtDatePickout(), pickout);      
		selectByValue(getTxtxAdult(), adultroom);        
		selectByValue(getTxtChild(), childroom);         
		click(getSearchBtn());
	}
	public void SearchHotel(String location,String roomnos,String pickin,String pickout,String adultroom) {
		selectByValue(getTxtLocation(), location);
		selectByValue(getTxtRoomNos(), roomnos);
		clear(getTxtDataPickin());
		
		sendData(getTxtDataPickin(), pickin);
		clear(getTxtDatePickout());
		
		sendData(getTxtDatePickout(), pickout);
		selectByValue(getTxtxAdult(), adultroom);
		click(getSearchBtn());
	}
	public void SearchHotel() {
	click(getSearchBtn());
	}
}