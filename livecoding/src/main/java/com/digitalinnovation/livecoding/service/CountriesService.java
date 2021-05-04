package com.digitalinnovation.livecoding.service;

import com.digitalinnovation.livecoding.document.Countries;
import com.digitalinnovation.livecoding.repository.CountriesRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CountriesService {
  private final CountriesRepository countriesRepository;

  public CountriesService(CountriesRepository countriesRepository) {
    this.countriesRepository = countriesRepository;
  }

  public Flux<Countries> findAll(){

    return Flux.fromIterable(this.countriesRepository.findAll());
  }

  public Mono<Countries> findCountryById(String id){

    return Mono.justOrEmpty(this.countriesRepository.findById(id));
  }


  public Mono<Countries> save(Countries countries){

    return  Mono.justOrEmpty(this.countriesRepository.save(countries));
  }


  public Mono<Boolean> deleteCountryById(String id) {
    countriesRepository.deleteById(id);

    return Mono.just(true);
  }

}
