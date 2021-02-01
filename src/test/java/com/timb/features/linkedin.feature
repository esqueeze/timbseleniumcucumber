Feature: Sending Messages On LinkedIn
  As a user
  I can send messages

  @smoke
  Scenario: Send a single message
    Given I log into LinkedIn
    When I search for 'Profectus Kamaljeet'
    And Send a message to him
    Then the message appears in my sent messages