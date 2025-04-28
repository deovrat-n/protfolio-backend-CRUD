# protfolio-backend-springboot


📊 Stock Portfolio Tracker - Backend
A Spring Boot application that manages user accounts, stock holdings, and portfolio tracking with Basic Authentication and MySQL database integration.



🚀 Features
User Registration and Authentication (Spring Security with Basic Auth)

Create and Manage User Portfolios

Store stock data and user-stock relationships

Integration-ready with FastAPI stock price updater

Secure Password Storage (BCrypt)

MySQL Database Support


 Tech Stack
Spring Boot 3.x

Spring Security (Basic Auth)

Spring Data JPA (Hibernate ORM)

MySQL (Database)

Maven (Build Tool)

🔥 Getting Started
1. Clone the repository
2. 2. Configure Database
Edit src/main/resources/application.properties:


⚙️ Running the Application
1. Build the project
 mvn clean install
2. Run the Spring Boot app
   mvn spring-boot:run
App will be live at: http://localhost:8080

🛠️ API Endpoints

Method	Endpoint	Description	Auth Required
POST	/users/register	Register a new user	❌ No
GET	/users/me	Get current logged-in user info	✅ Yes

📦 Requirements
Java 17+

Maven

MySQL Server


⭐ Happy Coding!
