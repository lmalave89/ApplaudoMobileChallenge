@Applaudo
Feature: Applaudo's challenge mobile

  Background: Wait start Fast Shopping main menu

  Scenario: Challenge with Fast Shopping application
    Given create a new shopping list
    When edit the shopping created before
    And delete two elements of the list
    And select the rest of the items on the list
    And archive the list created before
    And delete the archived list
    Then Verified there is no list in any section