package br.com.atech.test.flightservice.infra.clients;

import br.com.atech.test.flightservice.infra.dto.PilotDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("pilotservice")
public interface PilotsClient {

    @RequestMapping("/pilot/{id}")
    public PilotDto findById(@PathVariable("id") Long id);

}
