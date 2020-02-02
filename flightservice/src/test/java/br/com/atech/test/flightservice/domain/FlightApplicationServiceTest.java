package br.com.atech.test.flightservice.domain;

import br.com.atech.test.flightservice.infra.clients.AircraftClient;
import br.com.atech.test.flightservice.infra.clients.CityClient;
import br.com.atech.test.flightservice.infra.clients.PilotsClient;
import br.com.atech.test.flightservice.infra.dto.AircraftDto;
import br.com.atech.test.flightservice.infra.dto.CityDto;
import br.com.atech.test.flightservice.infra.dto.FlightDto;
import br.com.atech.test.flightservice.infra.dto.PilotDto;
import br.com.atech.test.flightservice.infra.dto.form.FlightFormDto;
import br.com.atech.test.flightservice.infra.util.DataCreator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles( profiles = {"test"} )
class FlightApplicationServiceTest {

    @MockBean
    FlightRepository flightRepository;

    @MockBean
    PilotsClient pilotsClient;

    @MockBean
    CityClient cityClient;

    @MockBean
    AircraftClient aircraftClient;

    @Autowired
    FlightApplicationService flightApplicationService;


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

        Mockito.verify(flightRepository, times(1))
                .save(any(Flight.class));

    }


    private void prepareTest() {
        Flight flight = DataCreator.getFlight();

        Mockito.when(flightRepository.findById(any(Long.class)))
                .thenReturn(Optional.ofNullable(flight));

        Mockito.when(flightRepository.findByStatusNot(any(FlightStatus.class),any(Pageable.class)))
                .thenReturn(new PageImpl<>(Collections.singletonList(flight)));

        Mockito.when(flightRepository.save(any(Flight.class))).then(i -> i.getArguments()[0]);

        Mockito.when(pilotsClient.findById(any(Long.class)))
                .thenReturn(PilotDto.builder().id(1L).fisrtName("Teste").build());

        Mockito.when(cityClient.findById(any(Long.class)))
                .thenReturn(new CityDto(1L, "Teste "));

        Mockito.when(aircraftClient.findById(any(Long.class)))
                .thenReturn(new AircraftDto(1L, "Aircraft"));
    }


}