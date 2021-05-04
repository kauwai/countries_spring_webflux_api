package com.digitalinnovation.livecoding.repository;

import com.digitalinnovation.livecoding.document.Countries;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface CountriesRepository extends CrudRepository<Countries, String> {
}
