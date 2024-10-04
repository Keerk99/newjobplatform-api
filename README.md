# New Job Platform API

## Description

This project is a Java-based API that allows you to manage companies, jobs, and reviews, as well as handle user registration and login. It uses **JWT** for authentication and **Swagger** for API documentation.

## Technologies Used

- **Spring Boot**
- **Spring Security with JWT**
- **Hibernate/JPA**
- **H2 Database** (or **MySQL** as the default database)
- **Swagger** for API documentation
- **Lombok**

## Database Configuration

This API can work with different databases, including **H2** (an in-memory database) and **MySQL**. By default, it is configured to use MySQL, and database migrations are handled using **Flyway** or **Liquibase**.

### Database Migration

Make sure to configure the migration tool (Flyway) to handle database schema changes and versioning. Migrations ensure that your database schema is always in sync with your application code.

## Entities

### 1. Company
- **Fields**:
  - `id`: Unique identifier of the company.
  - `name`: Name of the company.
  - `description`: Description of the company.
  - `jobs`: List of jobs associated with the company.
  - `reviews`: List of reviews associated with the company.

### 2. Job
- **Fields**:
  - `id`: Unique identifier of the job.
  - `title`: Job title.
  - `description`: Job description.
  - `minSalary`: Minimum salary.
  - `maxSalary`: Maximum salary.
  - `location`: Job location.
  - `company`: Company that posts the job.

### 3. Review
- **Fields**:
  - `id`: Unique identifier of the review.
  - `title`: Title of the review.
  - `description`: Review description.
  - `rating`: Rating.
  - `company`: Company to which the review belongs.

### 4. Users
- **Fields**:
  - `id`: Unique identifier of the user.
  - `username`: Username.
  - `password`: Encrypted password.

## Endpoints

### 1. Company Endpoints

- **GET** `/companies`: Retrieves all companies.
- **GET** `/companies/{companyId}`: Retrieves a company by its ID.
- **POST** `/companies`: Creates a new company.
- **PUT** `/companies/{companyId}`: Updates an existing company by its ID.
- **DELETE** `/companies/{companyId}`: Deletes a company by its ID.

### 2. Job Endpoints

- **GET** `/jobs`: Retrieves all jobs.
- **GET** `/jobs/{jobId}`: Retrieves a job by its ID.
- **POST** `/jobs`: Creates a new job.
- **PUT** `/jobs/{jobId}`: Updates an existing job by its ID.
- **DELETE** `/jobs/{jobId}`: Deletes a job by its ID.

### 3. Review Endpoints

- **GET** `/companies/{companyId}/reviews`: Retrieves all reviews for a company.
- **GET** `/companies/{companyId}/reviews/{reviewId}`: Retrieves a review by its ID for a specific company.
- **POST** `/companies/{companyId}/reviews`: Creates a new review for a company.
- **PUT** `/companies/{companyId}/reviews/{reviewId}`: Updates an existing review by its ID.
- **DELETE** `/companies/{companyId}/reviews/{reviewId}`: Deletes a review by its ID.

### 4. User Endpoints

- **POST** `/users`: Creates a new user (registration).
- **POST** `/login`: Logs in a user and returns a JWT.

## User Registration and Authentication

1. **Register a User**: Use the `POST /users` endpoint to create a new user.
2. **Login**: Use the `POST /login` endpoint to authenticate the user. Upon successful login, you will receive a JWT token.
3. **Access Protected Endpoints**: Use Postman or another API management tool to send requests to other endpoints. Select the "Bearer Token" option and include the JWT token in the authorization header to access protected resources.

## Custom Paginator

The API includes a custom paginator for returning paginated results. The paginator provides the following information:

- **totalPages**: The total number of pages available based on the current page size.
- **totalElements**: The total number of elements (items) available in the dataset.
- **size**: The number of items per page.
- **number**: The current page number (0-based index).
- **hasNext**: Indicates whether there is a next page available.
- **hasPrevious**: Indicates whether there is a previous page available.
- **nextPageUrl**: URL for the next page if it exists; otherwise, it will be `null`.
- **previousPageUrl**: URL for the previous page if it exists; otherwise, it will be `null`.
- **content**: An array containing the actual data objects for the current page.

### Usage

When making requests to endpoints that support pagination, you will receive the above information in the response, allowing you to easily navigate through the available data.

## Documentation

The API documentation can be accessed through Swagger UI. The default URL is: http://localhost:8080/swagger-ui/index.html

**Note:** The actual URL may vary based on your specific configuration:
- **Port**: If your application is running on a different port, please adjust the port number in the URL accordingly.
- **Context Path**: If your application is deployed with a specific context path, include that in the URL. For example, if your context path is `/api`, the URL will be `http://localhost:8080/api/swagger-ui.html`.

Make sure to check your application settings to determine the correct URL for accessing the Swagger UI.
