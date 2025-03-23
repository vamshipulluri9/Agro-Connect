# Agro Connect 🚜

Agro Connect is a microservices-based **social media platform for farmers and laborers**. Farmers can post agricultural jobs, and laborers can comment if they are interested.

## 🚀 Architecture

- **User Service**: Manages authentication, authorization, and user profiles. ✅ _Done_
- **Post Service**: Allows farmers to post agricultural work and laborers to comment. ✅ _Done_
- **View Service**: Fetches and displays posts. 🏗️ _Planned Next_
- **Gateway Service**: Routes API requests to the appropriate service. ✅ _Implemented_
- **Discovery Service**: Eureka-based service discovery for microservices. ✅ _Implemented_
- **Config Server**: Centralized configuration management. 🏗️ _Planned Next_

## 🛠 Technologies Used

| Purpose                 | Technology           |
| ----------------------- | -------------------- |
| **Backend Framework**   | Spring Boot 3.x      |
| **Security**            | Spring Security, JWT |
| **Database**            | PostgreSQL           |
| **API Gateway**         | Spring Cloud Gateway |
| **Service Discovery**   | Eureka Server        |
| **Configuration**       | Spring Cloud Config  |
| **Inter-Service Comm.** | REST API             |

## 🔧 Setup & Running the Services

### 1️⃣ Clone the Repository

```sh
git clone https://github.com/your-username/agro-connect.git
cd agro-connect

```

2️⃣ Start the Eureka Discovery Server
sh
Copy
Edit
cd discovery-service
mvn spring-boot:run
3️⃣ Start the API Gateway
sh
Copy
Edit
cd gateway-service
mvn spring-boot:run
4️⃣ Run Microservices
sh
Copy
Edit

# User Service

cd user-service
mvn spring-boot:run

# Post Service

cd post-service
mvn spring-boot:run

📌 API Endpoints
Service Endpoint Base URL
User Service http://localhost:8080/api/users/
Post Service http://localhost:8080/api/posts/
View Service http://localhost:8080/api/view/
🔜 Next Steps
✅ User Service Completed (JWT Auth, PostgreSQL, Role-Based Access)

✅ Post Service Completed (Create, Fetch, Comment on Posts)

⏳ View Service: Implementing optimized post retrieval

⏳ Config Server: Centralized configuration for all microservices

⏳ Kafka: Event-driven notifications

🏗 Contributing
Fork the repo 📌

Create a feature branch (git checkout -b feature-name)

Commit changes (git commit -m "Added feature")

Push to the branch (git push origin feature-name)

Open a Pull Request 🚀

📝 License
This project is licensed under the MIT License.
