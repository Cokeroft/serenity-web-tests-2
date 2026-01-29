Feature: Create Articles in the Test Application

  Background: Login to User
    # Scenario makes it so we can do this for each of our tests, cleans up a lot of clutter.
    Given Justin navigates to the test application landing page
    When he exits the onboarding modal
    When he clicks the sign in button
    Then he enters "qa_example3@betprophet.co" email and "gigqt4-moccep-Juvbyj" password into the corresponding fields

  @prophetx
  Scenario: Place a wager
    # Things to note here: Normally I would add functionality for extra checks, like balance, legality of bets, etc
    # But since this is meant to be simple, I won't build it out fully, but will add that information as it's important
    # A further fleshed out system would have extra steps built into each of these scenarios, for stability and testability
    When he clicks the first available moneyline
    Then he enters a small stake
    Then he clicks place play
    Then he clicks confirm play
    Then he has their wager matched successfully
