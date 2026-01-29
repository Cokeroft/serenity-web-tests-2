Feature: Additional Test Coverage

  Background: Login User
    Given Justin navigates to the test application landing page
    When he clicks the sign in button
    Then he enters "usera@test.com" email and "usera" password into the corresponding fields
    Then he clicks the sign in button from the sign in page

  @kraken @comments
  Scenario: User is able to create, view, and delete comments
    Given Justin clicks on the first article
    When he creates a comment that states "Hey, this is super cool!"
    Then he can see a comment that states "Hey, this is super cool!"
    Then he deletes the top comment

    @kraken @favorite
    Scenario: User is able to favorite and unfavorite articles
      Given Justin clicks on the first article
      When he favorites the article
      Then he clicks on the home button
      Then he clicks on the first article
      Then he sees the favorite counter has changed
