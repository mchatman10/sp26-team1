Zachary Fouts
## Title
> Smash Bros. Fiverr

## Team Members
> Michael Chatman
> Zachary Fouts

## Description 
Smash Bros. Fiverr is an app where people can share their talents in games in the Super Smash Brothers game series and assist customers in improving at the game. Providers would be hire-able coaches that set their own pay rates for players (customers) to pay and hire by the hour. They post themselves as a coach for hire with certain demographics checked like "main character" or "Super Smash Bros. Ultimate" and can write a description of their experience, results, etc. to better sell themselves. Customers can write reviews on coaches to promise the best results for a certain demographic of smash player (newer players, experienced players, etc.) that can be filtered by on the site. The app is made simply to better facilitate coaching for all demographics of Super Smash Bros. and increase the Smash Bros. player demographic.

## App Functions
1. Customer (the user with the customer role):
    1. Create/modify customer profile - Register for a client account
    2. View available coaching services - View active coaches and pay rates
    3. Purchase available services - Select based on coaching session type/length
    4. Write reviews for used services - Rate your experience with the coach, with an included description box
2. Provider (the user with the provider role):
    1. Create/modify provider profile - Register as a coach
    2. Create services - Post a coaching post with a pay rate and description
    3. Delete service - Delete a coaching post that is no longer being offered
    4. View customer feedback -  view customer reviews

    Controllers are used to handle GET and POST requests made to the server in order to interact with the database and keep the app functioning
    Services are programs used to handle the business logic side of things. They do most of the programming to facilitate between the Controllers and the Repositories
    Repositories are used to access the database for the app to get data from
    Models are the data structure/Java objects used for the database outline and for what data to store and use in each database.
    The Template Freemarker is the Ui organizer that that helps the java functions interact with the html files and the app function.