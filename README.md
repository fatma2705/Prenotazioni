```markdown
# Room and Operation Management REST API

This project is a RESTful API built with Java and Spring Boot for managing rooms and operations. It supports CRUD operations for both entities, checks room availability based on date and type, and handles room bookings and cancellations.

## Features

- CRUD operations for rooms (Stanza)
- CRUD operations for operations (Operazione)
- Check available rooms based on check-in and check-out dates and room type
- Book a room
- Cancel a booking and unlink the associated room

## Prerequisites

- Java 11 or later
- Maven
- Spring Boot
- H2 Database (or another database of your choice)

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/room-operation-management.git
   ```

2. Navigate to the project directory:
   ```bash
   cd room-operation-management
   ```

3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Endpoints

### Room Endpoints

- **Create a Room**
  ```http
  POST /rooms
  ```
  Request Body:
  ```json
  {
    "type": "string",
    "number": "int",
    "capacity": "int"
  }
  ```

- **Get All Rooms**
  ```http
  GET /rooms
  ```

- **Get a Room by ID**
  ```http
  GET /rooms/{id}
  ```

- **Update a Room**
  ```http
  PUT /rooms/{id}
  ```
  Request Body:
  ```json
  {
    "type": "string",
    "number": "int",
    "capacity": "int"
  }
  ```

- **Delete a Room**
  ```http
  DELETE /rooms/{id}
  ```

### Operation Endpoints

- **Create an Operation**
  ```http
  POST /operations
  ```
  Request Body:
  ```json
  {
    "description": "string",
    "date": "string (yyyy-MM-dd)",
    "roomId": "int"
  }
  ```

- **Get All Operations**
  ```http
  GET /operations
  ```

- **Get an Operation by ID**
  ```http
  GET /operations/{id}
  ```

- **Update an Operation**
  ```http
  PUT /operations/{id}
  ```
  Request Body:
  ```json
  {
    "description": "string",
    "date": "string (yyyy-MM-dd)",
    "roomId": "int"
  }
  ```

- **Delete an Operation**
  ```http
  DELETE /operations/{id}
  ```

### Booking Endpoints

- **Check Available Rooms**
  ```http
  GET /rooms/available
  ```
  Query Parameters:
  - `checkIn`: string (yyyy-MM-dd)
  - `checkOut`: string (yyyy-MM-dd)
  - `type`: string

- **Book a Room**
  ```http
  POST /bookings
  ```
  Request Body:
  ```json
  {
    "roomId": "int",
    "checkIn": "string (yyyy-MM-dd)",
    "checkOut": "string (yyyy-MM-dd)"
  }
  ```

- **Cancel a Booking**
  ```http
  DELETE /bookings/{id}
  ```

## Data Model

### Room (Stanza)

- `id` (Long): Unique identifier for the room
- `type` (String): Type of the room (e.g., single, double, suite)
- `number` (Int): Room number
- `capacity` (Int): Room capacity

### Operation (Operazione)

- `id` (Long): Unique identifier for the operation
- `description` (String): Description of the operation
- `date` (String): Date of the operation (yyyy-MM-dd)
- `roomId` (Long): ID of the associated room

## Running Tests

To run tests, use the following command:
```bash
mvn test
```

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
```

Feel free to copy and paste this into your project's README.md file on GitHub.
