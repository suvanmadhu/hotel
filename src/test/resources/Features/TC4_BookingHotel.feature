
Feature: Verifying Adactin Hotel Booking Page
@bookinghotel
  Scenario Outline: Verify Adactin Hotel Booking Page With Valid Credentials
    Given User is on the Adactin Home Page
    When User Should Perform Login "<UserName>","<Password>"
    And User Should Verify Welcome Message After Login "Hello madhusuvan!"
    And User Should Fill & Submit All Feilds In Search Hotel Page "<Location>","<Hotels>","<RoomType>","<NoOfRoom>","<Check-in>","<Check-out>","<AdultsPerRoom>" and "<ChildrenPerRoom>"
    And User Should Verify Message After Search "Select Hotel"
    And User Should Select Hotel
    And User Should Verify Message After Select "Book A Hotel"
    And User Should Book Hotel "<FirstName>","<LastName>" and "<Address>"and save generated orderID
      | CreditCardType   | CreditCardNo     | Month    | Year | CVVNumber |
      | American Express | 1234567887654321 | December | 2022 |       321 |
      | Visa             | 1234567887654321 | December | 2022 |       321 |
      | Master           | 1234567887654321 | December | 2022 |       321 |
    Then User Should Verify Message After Booking "Booking Confirmation"

    Examples: 
      | UserName   | Password | Location | Hotels      | RoomType | NoOfRoom | Check-in   | Check-out  | AdultsPerRoom | ChildrenPerRoom | FirstName | LastName | Address |
      | madhusuvan | V89276   | London   | Hotel Creek | Standard |        1 | 21/06/2022 | 23/06/2022 |             2 |               1 | barath    | c        | chennai |

  Scenario Outline: Verify Adactin Hotel Booking Page With Valid Credentials
    Given User is on the Adactin Home Page
    When User Should Perform Login "<UserName>","<Password>"
    And User Should Verify Welcome Message After Login "Hello madhusuvan!"
    And User Should Fill & Submit All Feilds In Search Hotel Page "<Location>","<Hotels>","<RoomType>","<NoOfRoom>","<Check-in>","<Check-out>","<AdultsPerRoom>" and "<ChildrenPerRoom>"
    And User Should Verify Message After Search "Select Hotel"
    And User Should Select Hotel
    And User Should Verify Message After Select "Book A Hotel"
    And User Should Book Hotel Without Filling All Mandatory Feilds save generated orderID
    Then User Should Verify All Error Message After Booking "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | UserName   | Password | Location | Hotels      | RoomType | NoOfRoom | Check-in   | Check-out  | AdultsPerRoom | ChildrenPerRoom |
      | madhusuvan | V89276   | London   | Hotel Creek | Standard |        1 | 21/06/2022 | 23/06/2022 |             2 |               1 |
