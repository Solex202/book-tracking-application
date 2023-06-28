package com.lotaproject.bookTracking.exception;

public class BookApplicationException extends RuntimeException {
    public BookApplicationException(String message) {
        super(message);
    }

//    #spring.datasource.url=jdbc:postgresql://localhost:5432/book-tracking-app?currentSchema=book-tracking-app
//            #spring.datasource.username=postgres
//#spring.datasource.password=password
//#spring.jpa.hibernate.ddl-auto=create
//#spring.jpa.show-sql=true
//            #spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
//#spring.datasource.driver-class-name=org.postgresql.Driver
//#spring.jpa.properties.hibernate.format_sql=true
//            #spring.config.import=secret.properties
//#server.error.include-message=always
}
