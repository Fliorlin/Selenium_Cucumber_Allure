Feature: Form test

  Scenario: Check form

    Given Fill TextField
    Then Fill Password
    Then Check disabled field
    Then Click Submit button
    Then Check Status Message
