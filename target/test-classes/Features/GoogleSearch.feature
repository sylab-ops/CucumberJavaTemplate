
Feature: feature to test google search functionality

Scenario: Validate google search is working
Given browser is open
And user is on google search page
When user enters a text in the search box
And hit enter
Then user is re-directed to search results page