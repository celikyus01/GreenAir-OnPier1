
Feature: Checking the related web page

    Background: For the scenarios in the feature file, user should be on the second page of the form
      Given user is on Persönliche Daten eingeben page


  Scenario Outline: User can fill the form with valid data
    Given user is on Persönliche Daten eingeben page
    Given user is on Privatperson form
    When user enters title "<Anrede>"
    And user enters first name "<Vorname>"
    And user enters surname "<Nachname>"
    And user enters email adress "<E-Mail-Adresse>"
    And user enters account holder "<Kontoinhaber>"
    And user enters iban no "<IBAN>"
    And user clicks on Weiter button
    Then form is created with given personal information

    Examples:
      | Anrede | Vorname | Nachname | E-Mail-Adresse           | Kontoinhaber | IBAN                          |
      | Herr   | John    | Doe      | anything%s@email.company | John Doe     | ZBDE 4578 9089 6556 4334 5400 |

  Scenario: user can not enter invalid name
    Given user is on Privatperson form
    When user enters a letter as a name
    Then error message appears under the Vorname field


  Scenario: user can not enter invalid surname
    Given user is on Privatperson form
    When user enters a letter as a surname
    Then error message appears under the Nachname field


  Scenario: Kontoinhaber(account holder) and the person name can be different
    Given user is on Privatperson form
    When user enters a different account holder name
    Then user verifies account holder name and person name can be different


  Scenario: Kontoinhaber(account holder) and the person name can be same
    Given user is on Privatperson form
    When user enters the Account holder name
    Then user verifies Account holder name and person name can be same

  Scenario: User fills the form with invalid email
    Given user is on Privatperson form
    When user enters invalid email
    And user clicks on Weiter button
    Then the form is created with invalid email


  Scenario:  user can create another account with the same email
    Given user is on Privatperson form
    When user enters  the same email
    And user clicks on Weiter button
    Then new user is created with the same email


  Scenario Outline: Account is created with valid IBAN
    Given user is on Privatperson form
    When user enters the "<IBAN>" number in the IBAN box
    And user clicks on Weiter button
    Then account is created

    Examples:
      | IBAN                                               |
      | 1234 1234 1234 1                                   |
      | 1234 1234 1234 12                                  |
      | 1234 1234 1234 1234 1234                           |
      | 1234 1234 1234 1234 1234 1234 1234 1234 1234 1234  |
      | 1234 1234 1234 1234 1234 1234 1234 1234 1234 1234 1|


  Scenario Outline: Account is not created with invalid IBAN
    Given user is on Privatperson form
    When user enters the invalid "<IBAN>" number in the IBAN box
    Then warning message is on screen, under the IBAN box

    Examples:
      | IBAN                              |
      | 1234 1234 1234                    |
      | 1234 1234 12                      |
      | 1234 1234                         |
      | 1234 1                            |




  Scenario: Data Validations
