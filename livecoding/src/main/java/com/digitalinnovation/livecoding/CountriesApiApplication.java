package com.digitalinnovation.livecoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;

@SpringBootApplication
@EnableDynamoDBRepositories
public class CountriesApiApplication {

  public static void main(String[] args) {

    SpringApplication.run(CountriesApiApplication.class, args);
    System.out.println("Countries API Started");
  }

}

