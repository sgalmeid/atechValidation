package br.com.atech.test.flightservice.infra.clients;

import br.com.atech.test.flightservice.infra.dto.CityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("cityservice")
public interface CityClient {

    @GetMapping("/cities/{id}")
    public CityDto findById(@PathVariable("id") Long id);
}
