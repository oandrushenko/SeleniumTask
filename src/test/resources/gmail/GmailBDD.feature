Feature: Gmail cucumber test

  Scenario: Checking the login to gmail account

    Given User login name "seleniumtask4.1@gmail.com"
    When User enter password "123qweasd!@#"
    Then User is able to create message