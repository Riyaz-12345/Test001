Feature: Application login
  Background:
    Given user database configuration
    When user launch the browser
    Then user submit form page should be displayed
    Then user called
  #Scenario: Admin page lagin

   # Given user is on subForm page
   # When user fill the all details "userName" and "password"
    #Then success massage should be displayed


    Scenario Outline:
      Given user is on subForm page
      When user fill the details "<userName>" and "<password>"
      Then success massage should be displayed

     Examples:
      | userName | password |
      | riyaz    | hello123 |
      | reiya    | Hi12349  |
      | Test01   | yes1234  |

      Scenario: Admin page login

        Given user is on subForm page
        When user fill the all details
             |name|
             |username|
             |password|
             | email  |
             | age    |
         Then success massage should be displayed

