@CancelHotel @RunAll
Feature: Verifying Adactin Hotel Cancel Page

  Scenario Outline: Verify Adactin Hotel Cancelling Page With Valid Credentials
  Given User is on the Adactin Home Page
    When User Should Perform Login "<Username>","<Password>"
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
    And User Should Cancel The Order Id
    Then User Should Verify Message After Cancelling "The booking has been cancelled."

    Examples: 
      | Username   | Password | Location | Hotels      | RoomType | NoOfRoom | Check-in   | Check-out  | AdultsPerRoom | ChildrenPerRoom | FirstName | LastName | Address |
      | madhusuvan | V89276   | London   | Hotel Creek | Standard |        1 | 26/06/2022 | 27/06/2022 |             2 |               1 | barath    | c        | chennai |

  Scenario Outline: Verify Adactin Hotel Cancelling Page With Valid Credentials
    Given User is on the Adactin Home Page
    When User Should Perform Login "<Username>","<Password>"
    And User Should Verify Welcome Message After Login "Hello madhusuvan!"
    And User Should Cancel The Previously Booked Order Id "<Order_Id>"
    Then User Should Verify Message After Cancelling "The booking has been cancelled."

    Examples: 
      | Username   | Password | Order_Id   |
      | madhusuvan | V89276   | K798FOFQ86 |
