# Kafka producer demo
This is a simple Kafka producer demo built with **Spring Boot**. It sends messages to an **Apache Kafka** topic, with API documentation provided via **Swagger UI**. This project is designed to work alongside the [Kafka Consumer Demo](https://github.com/dimazarembo/kafka-consumer-demo).

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.3-green)
![Kafka](https://img.shields.io/badge/Apache%20Kafka-2.8.0-blue)
![Springdoc](https://img.shields.io/badge/Springdoc-2.8.13-orange)

## Kafka

To start kafka use docker-compose.yaml where you need to add <ip> for advertised_listeners

### Run app
1. Install Java 17 and Maven.
2. Clone the repository: `git clone https://github.com/dimazarembo/kafka-producer-demo.git`
3. Navigate to the project directory: `cd kafka-producer-demo`
4. Rename `application-example.properties` to `application.properties`
5. 
```bash
cd kafka-producer-demo/src/main/resources
mv application-example.properties application.properties
```

5. Add your kafka bootstrap ips

```bash
nano application.properties
```

6. Run the application: `mvn spring-boot:run`
7. The API is available at `http://server-ip:8080/swagger-ui`

## Endpoints
- POST /orders - Create a message and send it to Kafka
  
{
  "product": "name",
  "quantity": 0
}
