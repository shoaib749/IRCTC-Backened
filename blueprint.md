# IRCTC-Backened
This is a Spring Boot application that provides APIs for managing train bookings. The application uses MySQL as the database for storing all the data. Whenever a request is received from the frontend, the application processes the request and sends the response in the form of JSON.

API Endpoints
1. /
Method: GET
Description: Retrieves the start date of the booking.
Response:
bookingStartedDate (date): The date when the booking started.
2. /adminLogin
Method: POST
Description: Allows the admin to log in to the application.
Request:
username (string): The admin's username.
password (string): The admin's password.
3. /addTrain
Method: POST
Description: Adds a new train to the system.
Request:
trainNo (int): The train's number.
trainName (string): The train's name.
startStation (Station): The train's starting station.
stopStation (Station): The train's destination station.
numberOfSeats (int): The total number of seats available on the train.
fare (int): The fare for the train journey.
4. /addStation
Method: POST
Description: Adds a new station to the system.
Request:
stationCode (int): The code of the station.
stationName (string): The name of the station.
5. /showTrain
Method: GET
Description: Retrieves all trains available in the system.
Response:
trains (List<Train>): A list of all trains.
6. /userRegister
Method: POST
Description: Registers a new user in the system.
Request:
userFullName (string): The full name of the user.
userName (string): The username chosen by the user.
password (string): The password chosen by the user.
7. /userLogin
Method: POST
Description: Allows the user to log in to the application.
Request:
username (string): The user's username.
password (string): The user's password.
8. /book/showTrain
Method: POST
Description: Retrieves available trains based on the start and stop stations and the date.
Request:
startStation (string): The starting station.
stopStation (string): The destination station.
date (Date): The date of the journey.
Response:
availableTrains (List<Train>): A list of trains available for the specified journey.
9. /book/ticketBooking
Method: POST
Description: Books a ticket for a user.
Request:
userId (int): The ID of the user.
logId (long): The ID of the train log.
noOfPassengers (int): The number of passengers for the booking.
10. /user/showMyTickets
Method: POST
Description: Retrieves all tickets booked by a user.
Request:
userId (int): The ID of the user.
Response:
bookedTickets (List<Ticket>): A list of tickets booked by the user.
Note: The types mentioned in the request and response sections are placeholders and should be replaced with the appropriate data models in your implementation.

Feel free to reach out if you have any further questions or need additional assistance!