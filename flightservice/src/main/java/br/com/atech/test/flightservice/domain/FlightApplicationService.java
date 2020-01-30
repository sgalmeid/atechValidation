package br.com.atech.test.flightservice.domain;


import br.com.atech.test.flightservice.infra.dto.FlightDto;
import br.com.atech.test.flightservice.infra.dto.form.FlightFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightApplicationService {

    private final FlightRepository flightRepository;

    public Page<FlightDto> list(final Pageable pageable){
        Page<Flight> flights = flightRepository.findAll(pageable);
       return new PageImpl<>(
               flights.get().map(FlightDto::new).collect(Collectors.toList()),
               pageable, flights.getTotalElements());

    }

    public FlightDto updateStatus(long id, FlightStatus newStatus) {
        Flight flight = flightRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        flight.updateStatus(newStatus);
        return new FlightDto(flightRepository.save(flight));

    }

    public FlightDto create(FlightFormDto flightFormDto) {
        return new FlightDto(flightRepository.save(new Flight(flightFormDto)));
    }
}