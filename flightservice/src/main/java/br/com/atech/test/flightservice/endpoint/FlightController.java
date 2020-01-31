package br.com.atech.test.flightservice.endpoint;

import br.com.atech.test.flightservice.domain.FlightApplicationService;
import br.com.atech.test.flightservice.domain.FlightStatus;
import br.com.atech.test.flightservice.infra.dto.FlightDto;
import br.com.atech.test.flightservice.infra.dto.form.FlightFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightApplicationService flightApplicationService;

    @GetMapping
    public Page<FlightDto> getFligth(Pageable pageable){
        return flightApplicationService.list(pageable);
    }

    @PatchMapping("/{id}/{status}")
    public FlightDto updateStatus(@PathVariable("id") long id, @PathVariable("status") FlightStatus status) {
        return flightApplicationService.updateStatus(id,status);
    }

    @PostMapping
    public FlightDto createFlight(@RequestBody FlightFormDto formDto){
        return flightApplicationService.create(formDto);
    }
}
