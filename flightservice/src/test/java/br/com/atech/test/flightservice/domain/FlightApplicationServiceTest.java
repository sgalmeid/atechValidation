package br.com.atech.test.flightservice.domain;

import br.com.atech.test.flightservice.infra.dto.AircraftDto;
import br.com.atech.test.flightservice.infra.dto.CityDto;
import br.com.atech.test.flightservice.infra.dto.FlightDto;
import br.com.atech.test.flightservice.infra.dto.PilotDto;
import br.com.atech.test.flightservice.infra.dto.form.FlightFormDto;
import br.com.atech.test.flightservice.infra.util.DataCreator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles( profiles = {"test"} )
class FlightApplicationServiceTest {

    @MockBean
    FlightRepository flightRepository;

    @Autowired
    FlightApplicationService flightApplicationService;

    @Test
    void shouldCallRepository() {
        Mockito.when(flightRepository.findAll(any(Pageable.class)))
                .thenReturn(new PageImpl<>(Collections.emptyList()));

        flightApplicationService.list(Pageable.unpaged());

        Mockito.verify(flightRepository, times(1))
                .findAll(any(Pageable.class));

    }

    @Test
    void shouldUpdateFligthStatus(){
        prepareTest();

        flightApplicationService.updateStatus(1L, FlightStatus.BOARDING_ON_TIME);

        Mockito.verify(flightRepository, times(1))
                .findById(any(Long.class));
        Mockito.verify(flightRepository, times(1))
                .save(any(Flight.class));
    }

    @Test
    void shouldCreateNewFligthInformation(){
        prepareTest();

        FlightFormDto flightFormDto = DataCreator.getFlightFormDto();

        FlightDto flightDto = flightApplicationService.create(flightFormDto);

        assertEquals(flightFormDto.getAircraft().getName(),flightDto.getAircraft());
        assertEquals(flightFormDto.getPilot().getName(),flightDto.getPilot());
        assertEquals(flightFormDto.getArrivalCity().getName(),flightDto.getArrivalCity());
        assertEquals(flightFormDto.getDepartureCity().getName(),flightDto.getDepartureCity());


        Mockito.verify(flightRepository, times(1))
                .save(any(Flight.class));

    }


    private void prepareTest() {
        Flight flight = DataCreator.getFlight();

        Mockito.when(flightRepository.findById(any(Long.class)))
                .thenReturn(Optional.ofNullable(flight));

        Mockito.when(flightRepository.save(any(Flight.class))).then(i -> i.getArguments()[0]);
    }


}