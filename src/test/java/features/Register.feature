@test
  Feature: Registration
    Scenario: As a user, I should able to register successfully
      So that, I can use all the user features on demonopecommerce website

      Given I am on registration page
      Then I enter required registration details
      And I click on register submit button
      Then I should able to registered successfully
      And I should be logged in