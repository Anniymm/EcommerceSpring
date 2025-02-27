# EcommerceSpring

  Welcome to the backend of the e-commerce website! This project is built using **Spring Boot**. It provides a comprehensive API for managing products, users and baskets.

## Features

- **User Authentication**: Secure user registration and JWT token-based authentication.
- **Product Management**: List, retrieve, and manage products.
- **Basket Management**: Add, remove, and view items in the user's basket.

## Prerequisites

- **Java 17 or higher**
- **Spring Boot 3.4 or higher**
- **Gradle**
- **PostgreSQL** (for database management)

## Installation

Follow these steps to set up the project locally:

1. **Clone the Repository**
   ```bash
   git clone https://github.com/Anniymm/EcommerceSpring.git
   cd EcommerceSpring

## Set Up the Database

Configure your `application.properties` or `application.yml` inside `src/main/resources/`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```
## Run the Application

If using **Gradle**:
```bash
./gradlew bootRun
```

## API Endpoints

All API endpoints and documentation can be found at:  

**GET** `/swagger-ui.html` - API documentation.


## Contributing

Welcome contributions to this project! If you'd like to contribute, please follow these steps:

1. **Fork the Repository**

   Click the "Fork" button at the top right of the repository page to create your own copy.

2. **Create a New Branch**

   ```bash
   git checkout -b feature-branch
   
 3. **Make Your Changes**

     Implement your feature or fix.

4. **Commit Your Changes**
   ```bash
   git add .
   git commit -m "Describe your changes"

5. **Push to Your Fork**
    ```bash
    git push origin feature-branch
    ```
## License

This project is licensed under the MIT License. For more details, please see the [LICENSE](LICENSE) file.





  


  

