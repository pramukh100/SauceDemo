Feature: Purchase some products
  As a User I want to go SauceDemo website
  And buy some products

  Scenario: standard user product purchase journey
    Given  User go to SauceDemo Website
    And    User select user name "standard_user" And password "secret_sauce"
    And    User click on login button
    And    User add "Sauce Labs Backpack" product in add to cart
    And    User go to the trolley
    And    User verify selected "Sauce Labs Backpack" item
    And    User click checkout button
    And    User enter "Name" and "Surname" and "WD25 0HH"
    And    User press continue
    And    User press finish button
    Then   User get order successful message
    And    User is logout from website

  Scenario: locked out user  journey
    Given  User go to SauceDemo Website
    And    User select user name "locked_out_user" And password "secret_sauce"
    And    User click on login button
    Then   User get locked out error message

  Scenario: problem user  journey
    Given  User go to SauceDemo Website
    And    User select user name "problem_user" And password "secret_sauce"
    And    User click on login button
    And    User select "Sauce Labs Backpack" product
    Then   User find other item than "Sauce Labs Backpack" on inventory item description
    And    User try to add product to cart
    And    User go to the trolley
    Then   User find trolley empty
    And    User click checkout button
    And    User enter "Name" and "Surname" and "WD25 0HH"
    And    User press continue
    Then   User can not proceed and see error message
    And    User is logout from website

  Scenario: performance glitch user  journey
    Given  User go to SauceDemo Website
    And    User select user name "performance_glitch_user" And password "secret_sauce"
    And    User click on login button
    And    User add "Sauce Labs Backpack" product in add to cart
    And    User go to the trolley
    And    User verify selected "Sauce Labs Backpack" item
    And    User click checkout button
    And    User enter "Name" and "Surname" and "WD25 0HH"
    And    User press continue
    And    User press finish button
    Then   User get order successful message
    And    User is logout from website


