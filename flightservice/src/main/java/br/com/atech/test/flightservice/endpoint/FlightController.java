package br.com.atech.test.flightservice.endpoint;

import br.com.atech.test.flightservice.domain.FlightApplicationService;
import br.com.atech.test.flightservice.infra.dto.FlightDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightApplicationService flightApplicationService;

    @GetMapping
    public Page<FlightDto> getFligth(Pageable pageable){
        return flightApplicationService.list(pageable);
    }
}
