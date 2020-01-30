package br.com.atech.test.flightservice.endpoint;

import br.com.atech.test.flightservice.domain.FlightRepository;
import br.com.atech.test.flightservice.domain.FlightStatus;
import br.com.atech.test.flightservice.infra.util.DataCreator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Arrays;
import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles(profiles = {"integrationTest"})
@Testcontainers
class FlightControllerTest {

    @Container
    private static PostgreSQLContainer container;

    static {
        container = new PostgreSQLContainer("postgres:11.1")
                .withDatabaseName("flights").withPassword("sa").withUsername("sa");
        container.setPortBindings(Collections.singletonList("2222:5432"));
    }

    @Autowired
    private FlightRepository flightRepository;

    @BeforeEach
    public void setup(){
        flightRepository.save(DataCreator.getFlight());
        flightRepository.save(DataCreator.getFlight());
        flightRepository.save(DataCreator.getFlight());
        flightRepository.save(DataCreator.getFlight());
    }

    @AfterEach
    public void unSetup() {
        flightRepository.deleteAll();
    }

    @Autowired
    public MockMvc mockMvc;

    @Test
    void getFligths() throws Exception {
        mockMvc.perform(get("/flights")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        .andDo(print());
    }

    @Test
    public void shountUpdateStatus() throws Exception {

        mockMvc.perform(patch("/flights/1/"+ FlightStatus.BOARDING_ON_TIME)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void shountErrorUpdateStatus() throws Exception {

        mockMvc.perform(patch("/flights/1/"+ FlightStatus.END_TRIP)
                .contentType(MediaType.APPLICATION_JSON))
               // .andExpect(status().isOk())
                .andDo(print());
    }
}