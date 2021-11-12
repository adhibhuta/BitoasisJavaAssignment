# Getting Started

## Basic Details
Consumes api from bitfinex every 10 seconds and stores the ticker in postgres. Can provide multiple ticker symbols as comma separated and the application has the capability of spinning up multiple threads to make concurrent connections. Along with the ticker data, there are two extra column for date and ticker symbol. 

## To Run

### Provide correct properties in application.properties file-

```
ticker.symbols=tBTCUSD,tETHUSD
bitfinex.header.user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36
bitfinex.ticker.uri=https://api-pub.bitfinex.com/v2/ticker/

logging.level.root=INFO
logging.level.com.bitoasis.javadevelopertask=TRACE

spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/bitoasis
spring.datasource.username=primary
spring.datasource.password=admin

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

### Run as a spring boot app

### To test the endpoints-
http://localhost:8080/swagger-ui/#/

