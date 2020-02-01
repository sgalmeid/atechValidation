package br.com.atech.test.aircraftservice.domain;


import br.com.atech.test.aircraftservice.infra.dto.AitcraftDto;
import br.com.atech.test.aircraftservice.infra.dto.form.AitcraftFormDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class AircraftApplicationService {

    private final AircraftRepository aircraftRepository;

    @HystrixCommand()
    public AitcraftDto findById(Long id){
        return aircraftRepository.findById(id)
                .map(m -> new AitcraftDto(m.getId(),m.getName()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @HystrixCommand()
    public AitcraftDto save(AitcraftFormDto form) {
        Aircraft aircraft = aircraftRepository.save(new Aircraft(form.getName()));
        return new AitcraftDto(aircraft.getId(), aircraft.getName());
    }

    @HystrixCommand()
    public List<AitcraftDto> findAll() {
        return StreamSupport.stream(aircraftRepository.findAll().spliterator(), false)
                .map(m -> new AitcraftDto(m.getId(),m.getName()))
                .collect(Collectors.toList());

    }
}
