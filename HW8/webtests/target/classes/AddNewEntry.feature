Feature: Добавление новой записи

  Background:
    Given User authorized

    Scenario
      When Click New Entry
      And Add New Entry
      Then Check Correct Page