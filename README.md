# Spring Boot REST API Example
Spring Boot Example of a fully featured REST API.

> Featured
- REST API using Spring MVC
- H2 In-Memory Database
- Models, DTOs, Repositories, Controllers, Exceptions
- With Swagger API Documentation

<br />

> Example Use Case
- We use QuickPoll service to create new Polls
- Each Poll contains a question, and a set of options
- Options inside a Poll can be updated at a later point
- QuickPoll restricts voting on one a single option
- Participants can cast any number of votes
- Results of a poll can be viewed by anyone

<br />

> YouTube Video
- Here is a short video explaining <b>Designing</b> and <b>Building</b> this example Step by Step [In-Progress]

<br />

> Notes
- There is <b>No Service Layer</b> to contain Business Logic as the example is so simple and adding it will be just a delegation from controllers to repositories, so I left it out of the Architecture.
- This Example is for <b>Educational Purposes</b> of how to implement a RESTful API using Spring MVC, Not Meant as a reference for designing a production grade REST API.
- If you're looking for a <b>Complete Example of a Production Grade Spring MVC RESTful API</b>, check out this other more complicated Example of a fully featured REST API with larger API, Testing and Documentation [In-Progress].
