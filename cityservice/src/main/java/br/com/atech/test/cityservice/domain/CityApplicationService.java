package br.com.atech.test.cityservice.domain;

import br.com.atech.test.cityservice.infra.dto.CityDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityApplicationService {

    private final CityRepository cityRepository;


    @HystrixCommand()
    @Hystrix(cacheKey = "cityById" )
    public CityDto findById(Long id) {
        return new CityDto(cityRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }



    @HystrixCommand()
    public List<CityDto> getCities(){
        List<CityDto> result = new ArrayList<>();
        cityRepository.findAll().forEach(f ->result.add(new CityDto(f)));
        return result;
    }

    @HystrixCommand()
    public List<CityDto> findByCity(String city) {
        return cityRepository.findByCityContainingIgnoreCase(city)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .stream().map(CityDto::new).collect(Collectors.toList());
    }

    @HystrixCommand()
    public List<CityDto> findByState(String state) {
        return cityRepository.findByStateContainingIgnoreCase(state)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .stream().map(CityDto::new).collect(Collectors.toList());
    }

    @HystrixCommand()
    public List<CityDto> findByCountry(String country) {
        return cityRepository.findByCountryContainingIgnoreCase(country)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .stream().map(CityDto::new).collect(Collectors.toList());
    }

    @HystrixCommand()
    public List<CityDto> findByCountryAndState(String country, String state) {
        return cityRepository.findByCountryAndStateContainingIgnoreCase(country, state)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .stream().map(CityDto::new).collect(Collectors.toList());
    }
}
