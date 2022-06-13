Feature: Добавление новой записи

  Background:
    Given User authorized

    @hooks
      @close


    Scenario
      When Click New Entry
      And Add New Entry
      Then Check Correct Page