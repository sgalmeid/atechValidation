package br.com.atech.test.flightservice.infra.clients;

import br.com.atech.test.flightservice.infra.dto.PilotDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("pilotservice")
public interface PilotsClient {

    @RequestMapping("/{id}")
    public PilotDto findById(Long id);


}
