package br.com.atech.test.pilotservice.domain;


import br.com.atech.test.pilotservice.infra.dto.PilotDto;
import br.com.atech.test.pilotservice.infra.dto.PilotShortDto;
import br.com.atech.test.pilotservice.infra.dto.form.PilotFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PilotApplicationService {

    private final PilotRepository pilotRepository;

    public List<PilotShortDto> list(){
       return StreamSupport.stream(pilotRepository.findAll().spliterator(),false)
                .collect(Collectors.toList()).stream()
        .map(m -> new PilotShortDto(m))
                .collect(Collectors.toList());
    }

    public PilotDto findPilotById(Long id) {
        return new PilotDto(pilotRepository
                .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    public PilotDto create(PilotFormDto pilotForm) {

        Pilot pilot = new Pilot(pilotForm.getFisrtName(),
                pilotForm.getLastName(),
                pilotForm.getBirthday(),
                pilotForm.getBreve(),
                pilotForm.getCity(),
                pilotForm.getStrret(),
                pilotForm.getCellNumber(),
                pilotForm.getEmail());

        return new PilotDto(pilotRepository.save(pilot));
    }


}
