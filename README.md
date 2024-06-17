# User Registration and Fetch API

## Description

This is a Spring Boot application providing RESTful API endpoints for user registration and fetching user details.

## API Endpoints

1. **Register User**
   - **URL:** `/api/user/register`
   - **Method:** POST
   - **Request Body:**
     ```json
     {
       "username": "use_rname",
       "email": "name@example.com",
       "password": "passxyz234"
     }
     ```
   - **Response:**
     - **201 Created:** User registered successfully.
     - **409 Conflict:** Username already exists.

2. **Fetch User**
   - **URL:** `/api/user/fetch`
   - **Method:** GET
   - **Query Parameter:** `username`
   - **Response:**
     - **200 OK:** User details.
     - **404 Not Found:** User not found.

## Running the Application

1. Clone the repository.
2. Navigate to the project directory.
3. Run the application 
