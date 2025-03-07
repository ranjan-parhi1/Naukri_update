Feature: Naukri Profile Update

  @naukri
  Scenario Outline: Update salary in Naukri profile with different credentials
    Given User is on Naukri homepage
    When User logs in with username "<username>" and password "<password>"
    And User navigates to profile page
    And User updates salary to "<salary>"
    Then User saves the changes successfully

    Examples:
      | username | password | salary  |
      | DB       | DB       | 3320000 |
      | DB       | DB       | 2800000 |