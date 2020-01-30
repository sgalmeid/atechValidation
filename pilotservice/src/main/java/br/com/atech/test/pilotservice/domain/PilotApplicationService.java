package br.com.atech.test.pilotservice.domain;


import br.com.atech.test.pilotservice.infra.dto.PilotDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PilotApplicationService {

    private final PilotRepository pilotRepository;

    public PilotDto findPilotById(Long id) {
        return new PilotDto(pilotRepository
                .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }


}
