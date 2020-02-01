package br.com.atech.test.flightservice.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FlightRepository extends PagingAndSortingRepository<Flight,Long> {


    Page<Flight> findByStatusNot(FlightStatus  status,  Pageable var1);
}
