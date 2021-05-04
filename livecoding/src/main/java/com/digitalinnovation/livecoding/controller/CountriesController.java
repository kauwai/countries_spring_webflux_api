package com.digitalinnovation.livecoding.controller;

import com.digitalinnovation.livecoding.document.Countries;
import com.digitalinnovation.livecoding.repository.CountriesRepository;
import com.digitalinnovation.livecoding.service.CountriesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.digitalinnovation.livecoding.constants.CountriesConstants.COUNTRIES_ENDPOINT;

@RestController
@Slf4j
public class CountriesController {
  CountriesService countriesService;

  CountriesRepository countriesRepository;

  private static final org.slf4j.Logger log =
    org.slf4j.LoggerFactory.getLogger(CountriesController.class);

  public CountriesController(CountriesService countriesService, CountriesRepository countriesRepository) {
    this.countriesService = countriesService;
    this.countriesRepository = countriesRepository;
  }

  @GetMapping(COUNTRIES_ENDPOINT)
  @ResponseStatus(HttpStatus.OK)
  public Flux<Countries> getAllCountries() {
    log.info("Requesting the list of all available countries...");
    return countriesService.findAll();

  }

  @GetMapping(COUNTRIES_ENDPOINT + "/{id}")
  public Mono<ResponseEntity<Countries>> findCountryById(@PathVariable String id) {
    log.info("Requesting country with provided id: {}", id);
    return countriesService.findCountryById(id)
      .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
      .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping(COUNTRIES_ENDPOINT)
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Countries> addCountry(@RequestBody Countries countries) {
    log.info("A new Country has been added");
    return countriesService.save(countries);

  }

  @DeleteMapping(COUNTRIES_ENDPOINT + "/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public Mono<HttpStatus> deleteCountryById(@PathVariable String id) {
    countriesService.deleteCountryById(id);
    log.info("Deleting Country with the provided id: {}", id);
    return Mono.just(HttpStatus.NO_CONTENT);
  }
}
