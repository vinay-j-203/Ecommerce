Feature: Landing to homepage and login

@Login
  Scenario Outline: user is on landing page
    When user clicks on login button
    And user enters username <Username> and pwd <Password>
    And clicks on login button
    Then navigate to home page
    Then logout of the application

    Examples: 
      | Username                    | Password        |
      | coddisabled@sharklasers.com | coddisabled@123 |
      
    
  @Invalid    
  Scenario: User is on Login Page
    When user clicks on login button
    And user enters username coddisabled@sharklasers.com and pwd cod@123
    And clicks on login button
    Then error message should be displayed

  Scenario: Forgot link
    When user clicks on login button
    Then Forgot link should be displayed
