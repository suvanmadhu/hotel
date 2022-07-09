package com.stepdefinition;
import org.junit.Assert;
import com.base.BaseClass;
import com.pagemanager.PageObjectManager;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class SelectHotelStep extends BaseClass {
	PageObjectManager pom=  new PageObjectManager();
	@When("User Should Select Hotel")
	public void user_Should_Select_Hotel() {
		pom.getSelecthotel().selectHotel();
	}
	@Then("User Should Verify Message After Select {string}")
	public void user_Should_Verify_Message_After_Select(String selectverify) {
		String selecttitle = getText(pom.getSelecthotel().getTitleMsg());
		Assert.assertTrue("verify book a hotel message",selecttitle.contains(selectverify));
		
//	   String selecthotel = getText(pom.getBookingpage().getBookingHotelverify());
//	   Assert.assertTrue("verify book a hotel messge",selecthotel.contains(selectverify));
	}
	@When("User Should Continue To Book Hotel Page Without Selecting Hotel")
	public void user_Should_Continue_To_Book_Hotel_Page_Without_Selecting_Hotel() {
	    pom.getSelecthotel().WithoutSelectHotel();		
	}
	@Then("User Should Verify Error Message After Not Selecting Hotel {string}")
	public void user_Should_Verify_Error_Message_After_Not_Selecting_Hotel(String select_HotelErr) {
	    String selectHotelErr = getText(pom.getSelecthotel().getSelectHotelverifyErr());
	Assert.assertTrue("verify error messge",selectHotelErr.contains(select_HotelErr));
	}
}