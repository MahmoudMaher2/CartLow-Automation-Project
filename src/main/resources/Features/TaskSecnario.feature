@TestRunner
Feature: Shopping Flow on Cartlow Website.

  Scenario: User Login and shops for laptop and smartwatch then proceeds to checkout
    Given User Navigate To Cartlow Website
    When  User Login with email "mahmoudmaher2033@gmail.com" and password "Mahmoud@maher1"
    And   User Opens Home Page and switches country from "INTL" to "UAE"
    And   User Opens Laptops Page and Select item Dell Latitude 7490 Then add to cart
    And   User Opens the SmartWatches page and adds 2 Apple Watch Series 6 items to the cart
    And   User Opens cart and Remove laptop then Proceed to checkout


















  Scenario: User change country
    Given User Navigate To Cartlow Website
    When  User Change Country From "INTL" to "UAE"
    When  User Change Country From "UAE" to "KSA"
    When  User Change Country From "KSA" to "INTL"

  Scenario: test
    Given User Navigate To Cartlow Website
    And   User Opens Laptops Page and Select item Dell Latitude 7490 Then add to cart
    And   User Opens the SmartWatches page and adds 2 Apple Watch Series 6 items to the cart
    And   User Opens cart and Remove laptop then Proceed to checkout











