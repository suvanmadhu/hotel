package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.base.BaseClass;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingHotelStep extends BaseClass {
	PageObjectManager pom=  new PageObjectManager();
	@When("User Should Book Hotel {string},{string} and {string}and save generated orderID")
	public void userShouldBookHotelAndAndSaveGeneratedOrderID(String FirstName, String LastName, String Addrees, io.cucumber.datatable.DataTable dataTable) {		
		List<Map<String,String>>a=dataTable.asMaps();
		Map<String,String>a1=a.get(0);
		String CreditCardNo = a1.get("CreditCardNo");
		String CreditCardType = a1.get("CreditCardType");
		String Month = a1.get("Month");
		String Year = a1.get("Year");
		String CVVNumber = a1.get("CVVNumber");
		
	   pom.getBookingpage().bookHotel(FirstName, LastName, Addrees, CreditCardNo, CreditCardType, Month, Year, CVVNumber);
		
	} 

	@Then("User Should Verify Message After Booking {string}")
	public void user_Should_Verify_Message_After_Booking(String booknowverify) {
//	String book_verify = getText(pom.getBookingconfirmationpage().getConfirmationMessage());
//	Assert.assertTrue("verify booking confirmation",book_verify.contains(booknowverify));
	}

	@When("User Should Book Hotel Without Filling All Mandatory Feilds save generated orderID")
	public void userShouldBookHotelWithoutFillingAllMandatoryFeildsSaveGeneratedOrderID() {
		pom.getBookingpage().bookHotel();
	
	}
	@Then("User Should Verify All Error Message After Booking {string},{string},{string},{string},{string},{string} and {string}")
	public void user_Should_Verify_All_Error_Message_After_Booking_and(String firstnameErr, String lastnameErr, String addressErr, String ccNumErr, String ccType, String ccExpiry, String cvvNum) {
	    String firstname_Err = getText(pom.getBookingpage().getFnErrMsg());
		Assert.assertTrue("verify firstname error",firstname_Err.contains(firstnameErr));
		
		String lastname_Err = getText(pom.getBookingpage().getLnErrMsg());
		Assert.assertTrue("verify lastnameErr error",lastname_Err.contains(lastnameErr));
		
		String AddressErrMsg = getText(pom.getBookingpage().getAddErrMsg());
		Assert.assertTrue("verify AddressErr",AddressErrMsg.contains(AddressErrMsg));
		
		 String ccnumberErr = getText(pom.getBookingpage().getCcNoErrMsg());
		 Assert.assertTrue("verify ccnumber",ccnumberErr.contains(ccNumErr));
		           
		 String cctype = getText(pom.getBookingpage().getCcTypeErrMsg());
		 Assert.assertTrue("verify the cctype",ccType.contains(ccType));
		 
		 String ccexp = getText(pom.getBookingpage().getCcExpErrMsg());
		 Assert.assertTrue("verify the ccexp",ccexp.contains(ccExpiry));
		 
		 String cvvnumber = getText(pom.getBookingpage().getCvvErrMsg());
		 Assert.assertTrue("verify cvvNumbb",cvvnumber.contains(cvvNum));
	}
}
