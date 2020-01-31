package br.com.atech.test.pilotservice.endpoint;

import br.com.atech.test.pilotservice.domain.PilotApplicationService;
import br.com.atech.test.pilotservice.infra.dto.PilotDto;
import br.com.atech.test.pilotservice.infra.dto.PilotShortDto;
import br.com.atech.test.pilotservice.infra.dto.form.PilotFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pilot")
@RequiredArgsConstructor
public class PilotController {

    private final PilotApplicationService pilotApplicationService;

    @GetMapping
    public List<PilotShortDto> list() {
       return pilotApplicationService.list();
    }

    @GetMapping("/{id}")
    public PilotDto findById(@PathVariable("id") Long id){
        return pilotApplicationService.findPilotById(id);
    }

    @PostMapping
    public PilotDto save(@RequestBody PilotFormDto pilotFormDto) {
        return pilotApplicationService.create(pilotFormDto);
    }
}
