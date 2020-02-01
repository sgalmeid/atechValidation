package br.com.atech.test.aircraftservice.endpoint;

import br.com.atech.test.aircraftservice.domain.AircraftApplicationService;
import br.com.atech.test.aircraftservice.infra.dto.AitcraftDto;
import br.com.atech.test.aircraftservice.infra.dto.form.AitcraftFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aircraft")
@RequiredArgsConstructor
public class AircraftController {

    private final AircraftApplicationService aircraftApplicationService;

    @GetMapping
    public List<AitcraftDto> findAll() {
        return aircraftApplicationService.findAll();
    }

    @GetMapping("/{id}")
    public AitcraftDto findById(@PathVariable("id") Long id) {
        return aircraftApplicationService.findById(id);
    }

    @PostMapping
    public AitcraftDto create(@RequestBody AitcraftFormDto form){
        return aircraftApplicationService.save(form);
    }

}
