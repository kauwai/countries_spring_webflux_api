package com.digitalinnovation.livecoding.config;


import java.util.Arrays;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import static com.digitalinnovation.livecoding.constants.CountriesConstants.DYNAMO_ENDPOINT;
import static com.digitalinnovation.livecoding.constants.CountriesConstants.DYNAMO_REGION;

public class CountriesTable {

  public static void main(String[] args) throws Exception {

    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
      .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(DYNAMO_ENDPOINT, DYNAMO_REGION))
      .build();

    DynamoDB dynamoDB = new DynamoDB(client);

    String tableName = "Countries_Api_Table";

    try {
      System.out.println("Creating table, please wait...");
      Table table = dynamoDB.createTable(tableName,
        Arrays.asList(new KeySchemaElement("id", KeyType.HASH)
        ),
        Arrays.asList(new AttributeDefinition("id", ScalarAttributeType.S)

        ),
        new ProvisionedThroughput(5L, 5L));
      table.waitForActive();
      System.out.println("Succeeded at creating table " + table.getDescription().getTableStatus());

    }
    catch (Exception e) {
      System.err.println("Failed at table creation");
      System.err.println(e.getMessage());
    }

  }

}
