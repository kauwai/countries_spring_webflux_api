package com.digitalinnovation.livecoding;

import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Test;
import com.digitalinnovation.livecoding.repository.CountriesRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.digitalinnovation.livecoding.constants.CountriesConstants.COUNTRIES_ENDPOINT;

@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class CountriesApiApplicationTests {

  @Autowired
  WebTestClient webTestClient;

  @Autowired
  CountriesRepository countriesRepository;

  @Test
  public void getCountryById(){

    webTestClient.get().uri(COUNTRIES_ENDPOINT.concat("/{id}"),"2")
      .exchange()
      .expectStatus().isOk()
      .expectBody();
  }

  @Test
  public void getCountryNotFound(){

    webTestClient.get().uri(COUNTRIES_ENDPOINT.concat("/{id}"),"10")
      .exchange()
      .expectStatus().isNotFound();

  }

  @Test
  public void deleteCountry(){

    webTestClient.delete().uri(COUNTRIES_ENDPOINT.concat("/{id}"),"1")
      .accept(MediaType.APPLICATION_JSON)
      .exchange()
      .expectStatus().isNotFound()
      .expectBody(Void.class);
  }

}
