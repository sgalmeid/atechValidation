package br.com.atech.test.flightservice.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface FlightRepository extends PagingAndSortingRepository<Flight,Long> {

}
