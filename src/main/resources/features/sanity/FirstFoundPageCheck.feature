Feature: As a business I want to be sure first found page related to search result has correct structure

  @Sanity
  Scenario Template: User can see the page title which contains searched word <text>

    Given I am at homepage
    When I search <text>
    And Click link <number> with result (not advertisement)
    Then I can see the page with title contains <text>

    Examples:
      | text         | number |
      | "automation" | 1      |