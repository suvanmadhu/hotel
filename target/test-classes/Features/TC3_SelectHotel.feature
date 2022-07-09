@SelectHotel
Feature: Verifying Adactin Hotel Select Page

  Scenario Outline: Verify Adactin Search Hotel Page With Valid Credentials
    Given User is on the Adactin Home Page
    When User Should Perform Login "<UserName>","<Password>"
    And User Should Verify Welcome Message After Login "Hello madhusuvan!"
    And User Should Fill & Submit All Feilds In Search Hotel Page "<Location>","<Hotels>","<RoomType>","<NoOfRoom>","<Check-in>","<Check-out>","<AdultsPerRoom>" and "<ChildrenPerRoom>"
    And User Should Verify Message After Search "Select Hotel"
    And User Should Select Hotel
    Then User Should Verify Message After Select "Book A Hotel"

    Examples: 
      | UserName   | Password | Location | Hotels      | RoomType | NoOfRoom | Check-in   | Check-out  | AdultsPerRoom | ChildrenPerRoom |
      | madhusuvan | V89276   | London   | Hotel Creek | Standard |        1 | 21/06/2022 | 23/06/2022 |             2 |               1 |

  Scenario Outline: Verify Adactin Search Hotel Page With Valid Credentials
    Given User is on the Adactin Home Page
    When User Should Perform Login "<UserName>","<Password>"
    And User Should Verify Welcome Message After Login "Hello madhusuvan!"
    And User Should Fill & Submit All Feilds In Search Hotel Page "<Location>","<Hotels>","<RoomType>","<NoOfRoom>","<Check-in>","<Check-out>","<AdultsPerRoom>" and "<ChildrenPerRoom>"
    And User Should Verify Message After Search "Select Hotel"
    And User Should Continue To Book Hotel Page Without Selecting Hotel
    Then User Should Verify Error Message After Not Selecting Hotel "Please Select a Hotel"

    Examples: 
      | UserName   | Password | Location | Hotels      | RoomType | NoOfRoom | Check-in   | Check-out  | AdultsPerRoom | ChildrenPerRoom |
      | madhusuvan | V89276   | London   | Hotel Creek | Standard |        1 | 21/06/2022 | 23/06/2022 |             2 |               1 |
