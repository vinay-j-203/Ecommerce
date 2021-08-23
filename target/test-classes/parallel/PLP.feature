Feature: PLP Page

  @PLP
  Scenario Outline: Opening PLP page and capturing the page title
    When user clicks on login button
    And user enters username <Username> and pwd <Password>
    And clicks on login button
    Then navigate to home page
    Then navigate to category page
    And capture the page title

    Examples: 
      | Username                    | Password        |
      | coddisabled@sharklasers.com | coddisabled@123 |
