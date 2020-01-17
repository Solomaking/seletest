Feature: As a business I want to be sure that my google search page position is high-ranked

  @Sanity
  Scenario Template: User search page by keyword and check that domain is present on first <result page amount> search result pages

    Given I am at homepage
    When I search <text>
    Then Related results present
    And My <domain name> is present on first <result page amount> pages

    Examples:
      | text          | domain name                      | result page amount |
      | "automation"  | "https://automated-testing.info" | 5                  |