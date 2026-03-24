UML class Diagram:
#![alt text](UML.jpg)

## API Endpoints

Customer Management

## Create Customer: POST /customers

{
  "username": "michael123",
  "password": "pass",
  "email": "michael@test.com",
  "phone": "123456",
  "fname": "Michael",
  "lname": "Chatman"
}

200 OK


## Update Customer: PUT /customers/{id}

{
  "username": "franklin123",
  "password": "pass",
  "email": "franklin@test.com",
  "phone": "123456",
  "fname": "Franklin",
  "lname": "Saint"
}
Response: Updated customer object
200 OK or 404 Not Found


## View Available Coaching Listings: GET /listings
200 OK or 404 Not Found


## Create Booking (Purchase): POST /bookings?customerId=1&listingId=1
200 OK or 404 Not Found


## Create a Review of a Booking: POST /reviews?customerId=1&listingId=1
{
  "rating": 5,
  "comment": "Great session!"
}
200 OK or 404 Not Found


## Delete Customer: DELETE /customers/{id}
200 OK or 404 Not Found


## Use case mapping

| Use Case | Description | Related Endpoints |
|----------|-------------|-------------------|
| **US-CUST-001** | Register & manage customer profile | `POST /customers`, `PUT /customers/{id}` |
| **US-CUST-002** | Browse coaching listings | `GET /listings`, `GET /listings/{id}` |
| **US-CUST-003** | Purchase listing | `POST /bookings?customerId=1&listingId=1` |
| **US-CUST-004** | Write a review | `POST /reviews?customerId=1&listingId=1` |
| **US-CUST-005** | Delete customer profile | `DELETE /customers/{id}` |