
Feature: Verifying Adactin Hotel Search Page

  Scenario Outline: Verify Adactin Search Hotel Page With Valid Credentials
    Given User is on the Adactin Home Page
    When User Should Perform Login "<UserName>","<Password>"
    And User Should Verify Welcome Message After Login "Hello madhusuvan!"
    And User Should Fill & Submit All Feilds In Search Hotel Page "<Location>","<Hotels>","<RoomType>","<NoOfRoom>","<Check-in>","<Check-out>","<AdultsPerRoom>" and "<ChildrenPerRoom>"
    Then User Should Verify Message After Search "Select Hotel"

    Examples: 
      | UserName   | Password | Location | Hotels      | RoomType | NoOfRoom | Check-in   | Check-out  | AdultsPerRoom | ChildrenPerRoom |
      | madhusuvan | V89276   | London   | Hotel Creek | Standard |        4 | 26/06/2022 | 27/06/2022 |             2 |               1 |

  Scenario Outline: Verify Adactin Search Hotel Page With Mandatory Feilds Only
    Given User is on the Adactin Home Page
    When User Should Perform Login "<UserName>","<Password>"
    And User Should Verify Welcome Message After Login "Hello madhusuvan!"
    And User Should Fill & Submit Only Mandatory Feilds In Search Hotel Page "<Location>","<NoOfRoom>","<Check-in>","<Check-out>" and "<AdultsPerRoom>"
    Then User Should Verify Message After Search "Select Hotel"

    Examples: 
      | UserName   | Password | Location | NoOfRoom | Check-in   | Check-out  | AdultsPerRoom |
      | madhusuvan | V89276   | London   |        4 | 26/06/2022 | 27/06/2022 |             2 |

  Scenario Outline: Verify Adactin Search Hotel Page With Invalid CheckIn & CheckOut Date
    Given User is on the Adactin Home Page
    When User Should Perform Login "<UserName>","<Password>"
    And User Should Verify Welcome Message After Login "Hello madhusuvan!"
    And User Should Fill Invaild CheckIn & CheckOut Date Except Other Feilds In Search Hotel Page "<Location>","<Hotels>","<RoomType>","<NoOfRoom>","<Check-in>","<Check-out>","<AdultsPerRoom>" and "<ChildrenPerRoom>"
    Then User Should Verify Error Message After Search "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | UserName   | Password | Location | Hotels      | RoomType | NoOfRoom | Check-in   | Check-out  | AdultsPerRoom | ChildrenPerRoom |
      | madhusuvan | V89276   | London   | Hotel Creek | Standard |        4 | 21/06/2026 | 23/06/2022 |             2 |               1 |
@SearchHotel 
  Scenario Outline: Verify Adactin Search Hotel Page Without Filling Any Details
    Given User is on the Adactin Home Page
    When User Should Perform Login "<UserName>","<Password>"
    And User Should Verify Welcome Message After Login "Hello madhusuvan!"
    Then User Should Verify Error Message After Search Without Filling Any Details "Please Select a Location"

    Examples: 
      | UserName   | Password |
      | madhusuvan | V89276   |
