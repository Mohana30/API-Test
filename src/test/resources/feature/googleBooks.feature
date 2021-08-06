@reg
Feature: Testing Google Books page

Scenario Outline: Validate the google books list and particular volume of my book shelf
When User request google books shelf lists with 200 response
Then Validate the book shelf <bookshelf> and title '<bookshelfTitle>'
And User request the <bookshelf> volumes and validate '<volumeTitle>' with 200 response

Examples:
|bookshelf|bookshelfTitle|volumeTitle|
|1001|API TEST|Behavior-Driven Development with Cucumber|
|2|To read|Technologies and Protocols for the Future of Internet Design: Reinventing the Web|

Scenario: Validate the google books endpoint with invalid bookshelf id
When User request google books shelf lists with 200 response
Then Validate the invalid book shelf 101 with 404 response and "The bookshelf ID could not be found." error message