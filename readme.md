# Organization-User
This project can be used to manage an organization and user. This project currently provides following features:

1. Create a single Organization

2. Create a single User

3. Add a User to an Organization

4. Delete a User from an Organization

5. Read all Users who belong to a specific Organization

6. Read all Organizations to which a User belongs

## Technologies used
To develop this small project developed using following things

1. Java 10

2. Spring boot

3. h2 which is an in-memory database

### Reason
I used Java 10 as the programming language to have more hands-on experience and I personally like java above other languages. But Java is one of the best Object oriented language for enterprise applications plus its features provides lot of freedom and benefits. Spring boot framework helps developers for faster development and deployment along with the trustworthy features of spring framework. In this scenario, I felt using in-memory database could be beneficial as it will be faster data access and we may not need to store too many records now. But if it comes to scalability and availability I would have used MongoDB/MySQL. MongoDB because its faster and we do not have too much of dependent/relational data in this scenario.

##Design
I used a design where controller and DTO should have no business logic so controller will only get the requests and delegates to service class. Service is responsible for all kind of business logic. DTO is just a JPA. It can be better improved based on using HQL.