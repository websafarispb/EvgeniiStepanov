Feature: Exercise one
  Scenario: Testing fluent page pattern page
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    When I click on 'Service' button in Header
    And I click on 'Different elements' button in Service dropdown
    And I select checkboxes 'Water, Wind'
    And I select radio 'Selen'
    And I select in dropdown 'Yellow'
    Then "Different elements" page should be opened
    And Log rows should contain following values:
      |Colors: value changed to Yellow |
      |metal: value changed to Selen   |
      |Wind: condition changed to true |
      |Water: condition changed to true|
