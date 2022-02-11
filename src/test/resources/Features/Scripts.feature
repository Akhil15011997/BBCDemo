Feature: Feature to validate BBC Webpage

  @Test @FullScript
  Scenario Outline: Validate BBC Webpage
    #Given Browser is open
    Given User is navigated to BBC webpage
    And User Accepts Cookies if shown
    Then User validates the top navigation links
    Then User validates the day and date
    And Navigate to the News webpage and verify URL
    Then Search "<inputtext>" via searchbox
    And Verify if search is related to "<inputtext>"

    Examples: 
      | inputtext                 |
      | Houghton Mifflin Harcourt |

  @Test @NavigationLinks
  Scenario: Validate BBC Webpage is opening as expected and navigation links
    #Given Browser is open
    Given User is navigated to BBC webpage
    And User Accepts Cookies if shown
    Then User validates the top navigation links

  @Test @DayandDate
  Scenario Outline: Validate day and date displayed in BBC Webpage
    #Given Browser is open
    Given User is navigated to BBC webpage
    And User Accepts Cookies if shown
    Then User validates the day and date

  @Test @NewsWebpage
  Scenario Outline: Validate News webpage
    #Given Browser is open
    Given User is navigated to BBC webpage
    And User Accepts Cookies if shown
    And Navigate to the News webpage and verify URL

  @Test @InputSearch
  Scenario Outline: Search text in BBC webpage
    #Given Browser is open
    Given User is navigated to BBC webpage
    And User Accepts Cookies if shown
    Then Search "<inputtext>" via searchbox
    And Verify if search is related to "<inputtext>"

    Examples: 
      | inputtext                 |
      | Houghton Mifflin Harcourt |
