# 🏦 Banking Application – Microservices Architecture (Spring Boot + Spring Cloud)

A production-grade **Banking Application** built using **Spring Boot Microservices**, **Spring Cloud**, **API Gateway**, **Eureka Discovery**, **Config Server**, **Circuit Breakers**, **RabbitMQ Bus**, and **Docker Compose**.

This project demonstrates a complete cloud-native microservices architecture with configuration management, service discovery, centralized routing, distributed tracing, fault-tolerance, and CI/CD for automated Docker builds.

---

# 🚀 Architecture Overview

pgsql
Copy code
              +----------------------+
              |     Config Server    | <-- Loads config from Git
              +----------+-----------+
                         |
                         ▼
                +----------------+
Client ---> | API Gateway |
+-------+--------+
|
------------------------------------
| | |
▼ ▼ ▼
+--------------+ +---------------+ +---------------+
| Accounts MS | | Loans MS | | Cards MS |
+--------------+ +---------------+ +---------------+
| | |
------------------------------------
|
+----------------+
| Eureka Server |
+----------------+

pgsql
Copy code
    +----------------------------------------+
    | RabbitMQ (Spring Cloud Bus Refresh)    |
    +----------------------------------------+
yaml
Copy code

---

# 📦 Microservices in This Repository

| Service Name        | Description |
|--------------------|-------------|
| **accounts-service** | Manages customer accounts, details, balances |
| **cards-service**    | Manages credit/debit card information |
| **loans-service**    | Manages loan data, approvals, repayments |
| **config-server**    | Centralized configuration for all microservices (Spring Cloud Config) |
| **eureka-server**    | Service discovery server (Netflix Eureka) |
| **gateway-server**   | API Gateway for routing, filtering, load balancing, circuit breakers |

---

# 🛠️ Technology Stack

### **Backend**
- Java 21  
- Spring Boot 3+  
- Spring Cloud 2023+  
- Spring WebFlux (Gateway)  
- Spring Cloud Config  
- Spring Cloud Eureka  
- Spring Cloud Bus  
- Spring Resilience4j (Circuit Breaker)  
- MapStruct (DTO mapping)  
- H2 Database (in-memory)

### **Message Broker**
- RabbitMQ (for Cloud Bus refresh events)

### **Infrastructure**
- Docker, Docker Compose  
- GitHub Actions (CI/CD using Docker Buildx Bake)

---

# ⚙️ Features Implemented

### ✔ Microservices with independent build and deployment  
### ✔ Service Discovery via Eureka  
### ✔ Centralized Configuration through Config Server  
### ✔ API Gateway
- Path rewriting  
- Load balancing (`lb://serviceName`)  
- Global Filters (Correlation ID)  
- Route Filters  
- Circuit Breakers  
- Fallback Handlers  

### ✔ Distributed Tracing
- Custom correlation-id filter  
- Request + response tracing  

### ✔ Fault Tolerance
- Resilience4j Circuit Breakers  
- Gateway-level fallbacks  
- Microservice-level fallbacks  

### ✔ Spring Cloud Bus (RabbitMQ) for dynamic config refresh  
### ✔ Docker Compose for complete service orchestration  
### ✔ GitHub Actions CI/CD  
- Build all microservice JARs  
- Docker bake to build all images  
- Automatic push to Docker Hub  

---

# 🧱 Project Structure

banking-application/
│
├── accounts-service/
├── cards-service/
├── loans-service/
├── config-server/
├── eureka-server/
├── gateway-server/
│
├── docker-compose/
│ ├── common-config.yml
│ ├── docker-compose.yml
│
├── docker-bake.hcl
└── README.md

yaml
Copy code

---

# 🏗️ Running the Application (Local)

## 1️⃣ Start RabbitMQ

```bash
docker compose -f docker-compose/docker-compose.yml up -d
RabbitMQ Dashboard:

makefile
Copy code
http://localhost:15672
user: guest
pass: guest
2️⃣ Start Eureka Server
bash
Copy code
cd eureka-server
mvn spring-boot:run
Visit Eureka Dashboard:

arduino
Copy code
http://localhost:8761
3️⃣ Start Config Server
bash
Copy code
cd config-server
mvn spring-boot:run
4️⃣ Start Other Microservices
bash
Copy code
cd accounts-service
mvn spring-boot:run

cd cards-service
mvn spring-boot:run

cd loans-service
mvn spring-boot:run
5️⃣ Start API Gateway
bash
Copy code
cd gateway-server
mvn spring-boot:run
🌐 API Gateway Routes
Route	Forwards To
/accounts/**	accounts-service
/cards/**	cards-service
/loans/**	loans-service

Example API call:

bash
Copy code
GET http://localhost:8072/accounts/customer/1
🔁 Circuit Breaker (Gateway-Level)
If accounts-service is DOWN:

bash
Copy code
GET /accounts/customer/1
Gateway returns fallback:

csharp
Copy code
Accounts Service is currently unavailable. Please try again later.
🧪 Health & Monitoring Endpoints
Endpoint	Description
/actuator/health	Service health
/actuator/gateway/routes	Gateway routes
/actuator/circuitbreakerevents	Circuit breaker logs
/actuator/metrics/resilience4j.circuitbreaker.calls	CB metrics

🐳 Running Entire System via Docker Compose
bash
Copy code
docker compose -f docker-compose/docker-compose.yml up --build
This starts:

RabbitMQ

Config Server

Eureka Server

Accounts Service

Loans Service

Cards Service

Gateway Server

🚀 CI/CD with GitHub Actions
The workflow:

Builds all microservice JARs

Builds Docker images using docker-bake.hcl

Pushes images to Docker Hub

Can run manually or on every push to main branch

🤝 Contributing
Contributions are welcome!
Please open an issue before submitting major changes.

📜 License
This project is open-source under the MIT License.
