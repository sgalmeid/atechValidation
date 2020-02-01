package br.com.atech.test.cityservice.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends CrudRepository<City, Long> {

   Optional<List<City>> findByCountryContainingIgnoreCase(String country);
   Optional<List<City>> findByStateContainingIgnoreCase(String state);
   Optional<List<City>> findByCityContainingIgnoreCase(String city);
   Optional<List<City>> findByCountryAndStateContainingIgnoreCase(String country, String State);
}
