package com.digitalinnovation.livecoding.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.digitalinnovation.livecoding.constants.CountriesConstants.DYNAMO_ENDPOINT;
import static com.digitalinnovation.livecoding.constants.CountriesConstants.DYNAMO_REGION;

public class CountriesData {
  public static void main(String[] args) throws Exception {

    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
      .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(DYNAMO_ENDPOINT, DYNAMO_REGION))
      .build();
    DynamoDB dynamoDB = new DynamoDB(client);

    Table table = dynamoDB.getTable("Countries_Api_Table");

    Item country1 = new Item()
      .withPrimaryKey("id", "1")
      .withString("name", "China")
      .withString("continent", "Asia")
      .withString("language", "Mandarin, Cantonese")
      .withNumber("population", 1397897720);

    Item country2 = new Item()
      .withPrimaryKey("id", "2")
      .withString("name", "Australia")
      .withString("continent", "Oceania")
      .withString("language", "English")
      .withNumber("population", 25809973);

    Item country3 = new Item()
      .withPrimaryKey("id", "3")
      .withString("name", "Cyprus")
      .withString("continent", "Europe")
      .withString("language", "Greek")
      .withNumber("population", 1281506);

    PutItemOutcome outcome1 = table.putItem(country1);
    PutItemOutcome outcome2 = table.putItem(country2);
    PutItemOutcome outcome3 = table.putItem(country3);

  }

}

