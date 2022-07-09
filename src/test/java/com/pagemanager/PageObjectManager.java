package com.pagemanager;

import com.base.BookingConfirmtionPage;
import com.base.BookingHotel;
import com.base.CancelBookingPage;
import com.base.Loginpage;
import com.base.SearchHotelPage;
import com.base.SelectHotel;
public class PageObjectManager {

	private Loginpage loginPage;
	private SearchHotelPage searchotelpage;
	
	private SelectHotel selecthotel;
	private BookingHotel bookingpage;																																															
	private BookingConfirmtionPage bookingconfirmationpage;
	private CancelBookingPage cancelbookingpage;
	public Loginpage getLoginPage() {
		return (loginPage==null)?loginPage=new Loginpage():loginPage;

	}
     public SearchHotelPage getSearchotelpage() {
	return (searchotelpage==null)?searchotelpage=new SearchHotelPage():searchotelpage;
	
	}
	public SelectHotel getSelecthotel() {
		return (selecthotel==null)?selecthotel=new SelectHotel():selecthotel;
				
	}
	public BookingHotel getBookingpage() {
		return (bookingpage==null)?bookingpage=new BookingHotel():bookingpage;
	}
	public BookingConfirmtionPage getBookingconfirmationpage() {
		return (bookingconfirmationpage==null)?bookingconfirmationpage=new BookingConfirmtionPage():bookingconfirmationpage;
	}
	public CancelBookingPage getCancelbookingpage() {
		return (cancelbookingpage==null)?cancelbookingpage=new CancelBookingPage():cancelbookingpage;
	}
	
}
