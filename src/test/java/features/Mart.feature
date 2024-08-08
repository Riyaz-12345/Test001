Feature: validating the product.
  Scenario: Searching the product and extracting the text value
    Given user is on greenkart page
    When user searched with shortname "Tom" and extracted actual name of the product
    Then user searched with the same name in cart and extracted same name of the product