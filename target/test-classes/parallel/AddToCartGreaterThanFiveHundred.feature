Feature: Cart Page Greater Than Five Hundred

  @ADDTOCARTGREATER
  Scenario Outline: Add a product to cart from PLP
    When user clicks on login button
    And user enters username <Username> and pwd <Password>
    And clicks on login button
    Then navigate to home page
    Then navigate to category page
    And capture the page title
    Then click on the first product
    And add that product to cart

    Examples: 
      | Username                    | Password        |
      | coddisabled@sharklasers.com | coddisabled@123 |
