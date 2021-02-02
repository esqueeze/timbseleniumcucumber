Feature: Sending Messages On LinkedIn
  As a user
  I can send messages

  @smoke
  Scenario: Send a single message
    Given I log into LinkedIn
    When I search for 'Kamaljeet Profectus'
    And Send a message to 'Kamaljeet Singh'
    Then the message appears in my sent messages