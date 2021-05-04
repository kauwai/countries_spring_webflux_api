package com.digitalinnovation.livecoding.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName ="Countries_Api_Table")
public class Countries {

  @Id
  @DynamoDBHashKey(attributeName = "id")
  private String id;

  @DynamoDBAttribute(attributeName = "name")
  private String name;

  @DynamoDBAttribute(attributeName = "continent")
  private String continent;

  @DynamoDBAttribute(attributeName = "language")
  private String language;

  @DynamoDBAttribute(attributeName = "population")
  private int population;

}
