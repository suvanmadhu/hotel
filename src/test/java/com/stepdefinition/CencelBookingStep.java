package com.stepdefinition;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CencelBookingStep {
	PageObjectManager pom = new PageObjectManager();

	// @When("User Should Book Hotel {string},{string} , {string} and Save Generated
	// Order ID")
	// public void user_Should_Book_Hotel_and_Save_Generated_Order_ID(String string,
	// String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
	//
	// }

	@When("User Should Cancel The Order Id")
	public void user_Should_Cancel_The_Order_Id() {
		BaseClass.implicitlyWait(30);
		String bookingConfirmation = pom.getBookingconfirmationpage().bookingConfirmation();
		pom.getCancelbookingpage().cancelBooking(bookingConfirmation);
	}

	@Then("User Should Verify Message After Cancelling {string}")
	public void user_Should_Verify_Message_After_Cancelling(String string) {

	}

	@When("User Should Cancel The Previously Booked Order Id {string}")
	public void user_Should_Cancel_The_Previously_Booked_Order_Id(String string) {
		pom.getCancelbookingpage().cancelBooking(string);
	}

}
