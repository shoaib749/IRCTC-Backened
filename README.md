<!-- ⚠️ This README has been generated from the file(s) "blueprint.md" ⚠️-->
[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/aqua.png)](#irctc-backened)

# ➤ IRCTC-Backened

[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#spring-boot-application---train-booking-api)

# ➤ Spring Boot Application - Train Booking API

This application is developed in Spring Boot and provides APIs for train booking. It utilizes MySQL as the database for storing data. The application receives requests from the frontend and responds with JSON data.


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#api-endpoints)

## ➤ API Endpoints

1. **Endpoint:** `/`
   - **Method:** GET
   - **Description:** Retrieves the booking started date.
   - **Response:** JSON containing the booking started date (`startDate`).

2. **Endpoint:** `/adminLogin`
   - **Method:** POST
   - **Description:** Authenticates the admin user.
   - **Request Body:**
     - `username` (string): Admin username.
     - `password` (string): Admin password.

3. **Endpoint:** `/addTrain`
   - **Method:** POST
   - **Description:** Adds a new train.
   - **Request Body:**
     - `trainNo` (int): Train number.
     - `trainName` (string): Train name.
     - `startStation` (Station): Starting station.
     - `stopStation` (Station): Destination station.
     - `numberOfSeats` (int): Total number of seats.
     - `fare` (int): Fare for the train.

4. **Endpoint:** `/addStation`
   - **Method:** POST
   - **Description:** Adds a new station.
   - **Request Body:**
     - `stationCode` (int): Station code.
     - `stationName` (string): Station name.

5. **Endpoint:** `/showTrain`
   - **Method:** GET
   - **Description:** Retrieves all trains.
   - **Response:** JSON array containing all train details (`trainList`).

6. **Endpoint:** `/userRegister`
   - **Method:** POST
   - **Description:** Registers a new user.
   - **Request Body:**
     - `userFullName` (string): Full name of the user.
     - `userName` (string): User's username.
     - `password` (string): User's password.

7. **Endpoint:** `/userLogin`
   - **Method:** POST
   - **Description:** Authenticates the user.
   - **Request Body:**
     - `username` (string): User's username.
     - `password` (string): User's password.

8. **Endpoint:** `/book/showTrain`
   - **Method:** POST
   - **Description:** Retrieves available trains based on start and stop stations and date.
   - **Request Body:**
     - `startStation` (string): Start station name.
     - `stopStation` (string): Stop station name.
     - `date` (Date): Date of travel.
   - **Response:** JSON array containing available train details (`trainList`).

9. **Endpoint:** `/book/ticketBooking`
   - **Method:** POST
   - **Description:** Books a ticket for a user.
   - **Request Body:**
     - `userId` (int): User ID.
     - `logId` (long): Login ID.
     - `noOfPassengers` (int): Number of passengers.
   - **Response:** JSON containing the booking details (`bookingDetails`).

10. **Endpoint:** `/user/showMyTickets`
    - **Method:** POST
    - **Description:** Retrieves tickets booked by a user.
    - **Request Body:**
      - `userId` (int): User ID.
    - **Response:** JSON array containing the booked ticket details (`ticketList`).


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#getting-started)

## ➤ Getting Started

To run this application locally, follow these steps:

1. Clone the repository:

```bash
git clone https://github.com/shoaib749/IRCTC-Backened.git
```

2. Navigate to

 the project directory:

```bash
cd train-booking-api
```

3. Build the project:

```bash
./mvnw clean package
```

4. Run the application:

```bash
./mvnw spring-boot:run
```

The application will start running on `http://localhost:8080`.

Remember to configure the MySQL database connection details in the `application.properties` file.


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#dependencies)

## ➤ Dependencies

The following dependencies are used in this Spring Boot application:

- Spring Web
- Spring Data JPA
- MySQL Driver

These dependencies are managed through Maven. The required dependencies will be automatically downloaded when building the project.
