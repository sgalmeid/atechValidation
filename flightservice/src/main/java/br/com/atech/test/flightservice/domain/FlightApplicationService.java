package br.com.atech.test.flightservice.domain;


import br.com.atech.test.flightservice.infra.clients.AircraftClient;
import br.com.atech.test.flightservice.infra.clients.CityClient;
import br.com.atech.test.flightservice.infra.clients.PilotsClient;
import br.com.atech.test.flightservice.infra.dto.AircraftDto;
import br.com.atech.test.flightservice.infra.dto.CityDto;
import br.com.atech.test.flightservice.infra.dto.FlightDto;
import br.com.atech.test.flightservice.infra.dto.PilotDto;
import br.com.atech.test.flightservice.infra.dto.form.FlightFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightApplicationService {

    private final FlightRepository flightRepository;
    private final PilotsClient pilotsClient;
    private final CityClient cityClient;
    private final AircraftClient aircraftClient;

    public Page<FlightDto> list(final Pageable pageable){
        Page<Flight> flights = flightRepository.findByStatusNot(FlightStatus.END_TRIP,  pageable);
       return new PageImpl<>(
               flights.get().map(FlightDto::new).collect(Collectors.toList()),
               pageable, flights.getTotalElements());

    }

    public FlightDto updateStatus(long id, FlightStatus newStatus) {
        Flight flight = flightRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        flight.updateStatus(newStatus);
        return new FlightDto(flightRepository.save(flight));

    }

    public FlightDto create(FlightFormDto formFlight) {
        PilotDto pilot = pilotsClient.findById(formFlight.getPilot());
        CityDto departure = cityClient.findById(formFlight.getDepartureCity());
        CityDto arrive = cityClient.findById(formFlight.getArrivalCity());
        AircraftDto aircraftDto = aircraftClient.findById(formFlight.getAircraft());
        cityClient.findById(formFlight.getArrivalCity());
        Flight flight = new Flight(formFlight.getDepartureTime(),
                formFlight.getArrivalTime(),
                new City(departure),
                new City(arrive),
                new Aircraft(aircraftDto),
                Pilot.builder().id(pilot.getId())
                .name(pilot.getFisrtName()).build()
                );
        return new FlightDto(flightRepository.save(flight));
    }
}
