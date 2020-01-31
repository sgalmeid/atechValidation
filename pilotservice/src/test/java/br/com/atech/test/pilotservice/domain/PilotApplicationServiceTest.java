package br.com.atech.test.pilotservice.domain;


import br.com.atech.test.pilotservice.infra.dto.form.PilotFormDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles( profiles = {"test"} )
public class PilotApplicationServiceTest {

    @MockBean
    PilotRepository pilotRepository;

    @Autowired
    PilotApplicationService pilotApplicationService;

    @BeforeEach
    public void setup() {

        Mockito.when(pilotRepository.findById(any(Long.class)))
                .thenReturn(getPilotMock());

        Mockito.when(pilotRepository.save(any(Pilot.class)))
                .then(i -> i.getArguments()[0]);

    }

    private Optional<Pilot> getPilotMock() {
        return Optional.of(new Pilot("FistName", "LastName",
                LocalDate.of(1980, 2, 3),
                "breve", "cityName", "StretName",
                "(12)9 9988-7766", "piloto@piloto.com"));
    }

    @Test
    public void shouldFinUser(){
        pilotApplicationService.findPilotById(1L);
        Mockito.verify(pilotRepository, times(1))
                .findById(any(Long.class));
    }

    @Test void shouldNewPilot(){
        PilotFormDto pilotForm = PilotFormDto.builder()
                .birthday(LocalDate.now())
                .breve("1234qwert")
                .cellNumber("12 9999 9999")
                .city("Taubaté")
                .email("pilot@piloto.com")
                .fisrtName("Piloto")
                .lastName(" de Teste")
                .strret("aqui perto")
                .build();

        pilotApplicationService.create(pilotForm);

        Mockito.verify(pilotRepository, times(1))
                .save(any(Pilot.class));
    }

}