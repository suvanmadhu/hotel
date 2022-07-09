package com.stepdefinition;
import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchHotelStep extends BaseClass {
	
	PageObjectManager pom=  new PageObjectManager();
	@When("User Should Fill & Submit All Feilds In Search Hotel Page {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_Should_Fill_Submit_All_Feilds_In_Search_Hotel_Page_and(String location, String hotels, String roomtype, String roomnos, String pickin, String pickout, String adultroom, String childroom) {
	   pom.getSearchotelpage().SearchHotel(location, hotels, roomtype, roomnos, pickin, pickout, adultroom, childroom);
		
	}

	@Then("User Should Verify Message After Search {string}")
	public void user_Should_Verify_Message_After_Search(String msgTitle) {
		String text = getText(pom.getSearchotelpage().getMsgTitle());
		Assert.assertTrue("verify Select Hotel",text.contains(msgTitle));
		
	}

	@When("User Should Fill & Submit Only Mandatory Feilds In Search Hotel Page {string},{string},{string},{string} and {string}")
	public void user_Should_Fill_Submit_Only_Mandatory_Feilds_In_Search_Hotel_Page_and(String location, String roomnos, String pickin, String pickout, String adultroom) {
	    pom.getSearchotelpage().SearchHotel(location, roomnos, pickin, pickout, adultroom);
	}

	@When("User Should Fill Invaild CheckIn & CheckOut Date Except Other Feilds In Search Hotel Page {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_Should_Fill_Invaild_CheckIn_CheckOut_Date_Except_Other_Feilds_In_Search_Hotel_Page_and(String location, String hotels, String roomtype, String roomnos, String pickin, String pickout, String adultroom, String childroom) {
	    pom.getSearchotelpage().SearchHotel(location, hotels, roomtype, roomnos, pickin, pickout, adultroom, childroom);
	}

	@Then("User Should Verify Error Message After Search {string},{string}")
	public void user_Should_Verify_Error_Message_After_Search(String indateERR, String outdateERR) {
		String inErr = getText(pom.getSearchotelpage().getIndate());
		System.out.println(inErr);
		Assert.assertTrue("verify", inErr.contains(indateERR));
		String outErr = getText(pom.getSearchotelpage().getOutdate());
		System.out.println(outErr);
		Assert.assertTrue("verify", outErr.contains(outdateERR));
	}
//
//	@When("User Should Submit Search Hotel Page Without Filling Any Details")
//	public void user_Should_Submit_Search_Hotel_Page_Without_Filling_Any_Details() {
//		pom.getSearchotelpage().SearchHotel();
//	    
//	}

	@Then("User Should Verify Error Message After Search Without Filling Any Details {string}")
	public void user_Should_Verify_Error_Message_After_Search(String errMsg) {
		pom.getSearchotelpage().SearchHotel();
		BaseClass.implicitlyWait(30);
		String message = getText(pom.getSearchotelpage().getErrmsg());
		System.out.println(message);
	     Assert.assertTrue("verify", message.contains(errMsg));
		
	}
}
