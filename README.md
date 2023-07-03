# Hibernate Using org.hibernate.cfg.Configuration

This repository demonstrates the usage of Hibernate with the `org.hibernate.cfg.Configuration` class for configuring the Hibernate framework. The project structure consists of three packages: `com.example.hibernate.util`, `com.example.hibernate.dao`, and `com.example.hibernate.model`.

## Packages Overview

### com.example.hibernate.util
This package contains the `HibernateConnectionConfig` class. This class is responsible for configuring the Hibernate properties and establishing the MySQL database connection. It sets up the necessary connection details, such as the database URL, username, password, and other configuration options.

### com.example.hibernate.dao
The `com.example.hibernate.dao` package contains the Data Access Object (DAO) classes. These classes encapsulate the logic for interacting with the database, including saving and retrieving data or objects. The DAO classes provide methods to perform various database operations using Hibernate, such as creating, updating, deleting, and querying data.

### com.example.hibernate.model
The `com.example.hibernate.model` package contains the model classes or annotated entities. These classes define the schema or structure of the database tables. They represent the entities or objects that will be stored in the database. Annotations, such as `@Entity`, `@Table`, `@Column`, etc., are used to map the model classes to the corresponding database tables and columns.

### App class
The `App` class serves as the main driver program. It demonstrates how to use the DAO classes and Hibernate configuration to perform CRUD (Create, Read, Update, Delete) operations on the database. It showcases the usage of the Hibernate API for persisting data and retrieving data from the database using the DAO layer.

## Getting Started

To run the project locally, follow these steps:

1. Ensure you have Java and MySQL installed on your machine.

2. Clone the repository to your local machine or download the source code.

3. Open the project in your preferred Java IDE.

4. Set up the MySQL database and create the necessary tables according to the model classes defined in the `com.example.hibernate.model` package.

5. Configure the database connection properties in the `HibernateConnectionConfig` class located in the `com.example.hibernate.util` package. Update the URL, username, password, and any other relevant details to match your MySQL database configuration.

6. Build and run the `App` class to execute the sample operations and interact with the database.

Feel free to explore and modify the code as needed to suit your requirements. Have fun with Hibernate and database interactions using the `org.hibernate.cfg.Configuration` approach!

If you have any questions or need further assistance, please don't hesitate to reach out.
