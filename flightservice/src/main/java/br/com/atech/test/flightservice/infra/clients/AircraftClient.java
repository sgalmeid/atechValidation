package br.com.atech.test.flightservice.infra.clients;

import br.com.atech.test.flightservice.infra.dto.AircraftDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("aircraftservice")
public interface AircraftClient {

    @GetMapping("aircraft/{id}")
    public AircraftDto findById(@PathVariable("id") Long id);
}
