@wip
Feature: Checking the related web page

  Background: For the scenarios in the feature file, user should be on the second page of the form
    Given user is on Persönliche Daten eingeben page
    When user selects vehicle class
    And user selects flexPramieBentragen package
    And user uploads images of vehicle registration
    And user clicks on "Weiter " button
    Then user verifies title as "THG Prämie"

  Scenario Outline: Form submission
    When user selects title "<title>"
    And user fills "Vorname" as "<firstName>"
    And user fills "Nachname" as "<lastName>"
    And user fills "E-Mail-Adresse" as "<email>"
    And user fills "Kontoinhaber" as "<accountHolder>"
    And user fills "IBAN" as "<IBAN>"
    And user clicks on Weiter button
    Then form is created with given personal information
      | Anrede         |
      | Vorname        |
      | Nachname       |
      | E-Mail-Adresse |
      | Kontoinhaber   |
      | IBAN           |
    Examples:
      | title | firstName | lastName | email                    | accountHolder | IBAN                          |
      | Herr  | John      | Doe      | anything%s@email.company | John Doe      | ZBDE 4578 9089 6556 4334 5400 |

  Scenario Outline: user can not enter invalid name
    When user fills "Vorname" as "<invalidFirstName>"
    Then error message appears under the Vorname field
    Examples:
      | invalidFirstName |
      | a                |
#      |                                                                            |
#      | Lorem Ipsum is simply dummy text of the printing and typesetting industry. |
#      | 12345                                                                      |
#      | @£$                                                                        |

  Scenario Outline: user can not enter invalid surname
    And user fills "Nachname" as "<invalidSurname>"
    And user clicks another placeholder to fill and proceed
    Then error message appears under the Nachname field
    Examples:
      | invalidSurname                                                                                                                                      |
      | a                                                                                                                                                   |
      |                                                                                                                                                     |
      | Lorem Ipsum is simply dummy text of the printing and typesetting industry Lorem Ipsum is simply dummy text of the printing and typesetting industry |
      | 12345                                                                                                                                               |
      | @£$                                                                                                                                                 |

  Scenario Outline: Kontoinhaber(account holder) and the person name can be different
    When user selects title "<title>"
    And user fills "Vorname" as "<firstName>"
    And user fills "Nachname" as "<lastName>"
    And user fills "E-Mail-Adresse" as "<email>"
    And user fills "Kontoinhaber" as "<accountHolder>"
    And user fills "IBAN" as "<IBAN>"
    And user clicks on "Weiter " button
    Then user verifies account holder name and person name can be different
    Examples:
      | title | firstName | lastName | email                    | accountHolder | IBAN                          |
      | Herr  | John      | Doe      | anything%s@email.company | Elif Basbug   | ZBDE 4578 9089 6556 4334 5400 |

  Scenario Outline: User fills the form with invalid email
    When user selects title "<title>"
    And user fills "Vorname" as "<firstName>"
    And user fills "Nachname" as "<lastName>"
    And user fills "E-Mail-Adresse" as "<email>"
    And user fills "Kontoinhaber" as "<accountHolder>"
    And user fills "IBAN" as "<IBAN>"
    And user clicks on Weiter button
    Then the form is created with valid email
    Examples:
      | title | firstName | lastName | email                          | accountHolder | IBAN                          |
      | Herr  | John      | Doe      | email@example.com              | John Doe      | ZBDE 4578 9089 6556 4334 5400 |
      | Herr  | John      | Doe      | firstname.lastname@example.com | John Doe      | ZBDE 4578 9089 6556 4334 5400 |
      | Herr  | John      | Doe      | email@subdomain.example.com    | John Doe      | ZBDE 4578 9089 6556 4334 5400 |
      | Herr  | John      | Doe      | firstname+lastname@example.com | John Doe      | ZBDE 4578 9089 6556 4334 5400 |
      | Herr  | John      | Doe      | email@123.123.123.123          | John Doe      | ZBDE 4578 9089 6556 4334 5400 |
      | Herr  | John      | Doe      | email@[123.123.123.123]        | John Doe      | ZBDE 4578 9089 6556 4334 5400 |
      | Herr  | John      | Doe      | "email"@example.com            | John Doe      | ZBDE 4578 9089 6556 4334 5400 |
      | Herr  | John      | Doe      | 1234567890@example.com         | John Doe      | ZBDE 4578 9089 6556 4334 5400 |
      | Herr  | John      | Doe      | email@example-one.com          | John Doe      | ZBDE 4578 9089 6556 4334 5400 |
      | Herr  | John      | Doe      | _______@example.com            | John Doe      | ZBDE 4578 9089 6556 4334 5400 |
      | Herr  | John      | Doe      | email@example.name             | John Doe      | ZBDE 4578 9089 6556 4334 5400 |
      | Herr  | John      | Doe      | email@example.museum           | John Doe      | ZBDE 4578 9089 6556 4334 5400 |


  Scenario:  Field data validations
    Then user validates the validation messages
      | label          | value                         | expectedMessage                                      |
      | Vorname        | a                             | Der Vorname muss mindestens zwei Zeichen lang sein.  |
      | Vorname        | Jhon                          | none                                                 |
      | Vorname        | .                             | Bitte geben Sie Ihren Vornamen ein.                  |
      | Vorname        |                               | Bitte geben Sie Ihren Vornamen ein.                  |
      | Nachname       | a                             | Der Nachname muss mindestens zwei Zeichen lang sein. |
      | Nachname       | .                             | Bitte geben Sie Ihren Nachnamen ein.                 |
      | Nachname       |                               | Bitte geben Sie Ihren Nachnamen ein.                 |
      | E-Mail-Adresse |                               | Bitte geben Sie Ihre E-Mail-Adresse ein.             |
      | E-Mail-Adresse | #@%^%#$@#$@#.com              | Bitte geben Sie eine gültige E-Mail-Adresse ein.     |
      | E-Mail-Adresse | @example.com                  | Bitte geben Sie eine gültige E-Mail-Adresse ein.     |
      | E-Mail-Adresse | Joe Smith <email@example.com> | Bitte geben Sie eine gültige E-Mail-Adresse ein.     |
      | E-Mail-Adresse | email.example.com             | Bitte geben Sie eine gültige E-Mail-Adresse ein.     |
      | E-Mail-Adresse | email@example@example.com     | Bitte geben Sie eine gültige E-Mail-Adresse ein.     |
      | E-Mail-Adresse | email@example.com (Joe Smith) | Bitte geben Sie eine gültige E-Mail-Adresse ein.     |
      | E-Mail-Adresse | email@example.com             | email@example.com                                           |
      | E-Mail-Adresse | email@example.com             | firstname.lastname@example.com                              |
      | E-Mail-Adresse | email@example.com             | email@subdomain.example.com                                 |
      | E-Mail-Adresse | email@example.com             | firstname+lastname@example.com                              |
      | E-Mail-Adresse | email@example.com             | email@123.123.123.123                                       |
      | E-Mail-Adresse | email@example.com             | email@[123.123.123.123]                                     |
      | E-Mail-Adresse | email@example.com             | "email"@example.com                                         |
      | E-Mail-Adresse | email@example.com             | 1234567890@example.com                                      |
      | E-Mail-Adresse | email@example.com             | email@example-one.com                                       |
      | E-Mail-Adresse | email@example.com             | _______@example.com                                         |
      | E-Mail-Adresse | email@example.com             | email@example.name                                          |
      | E-Mail-Adresse | email@example.com             | email@example.museum                                        |


  @happypath
  Scenario: User cancels form
    And user clicks on Zurück button
    Then user lands on previous page




