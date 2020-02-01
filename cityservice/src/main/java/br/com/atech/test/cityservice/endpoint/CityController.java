package br.com.atech.test.cityservice.endpoint;

import br.com.atech.test.cityservice.domain.CityApplicationService;
import br.com.atech.test.cityservice.infra.dto.CityDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("cities")
public class CityController {

    private final CityApplicationService cityApplicationService;

    @GetMapping
    public List<CityDto> getCities(){
        return cityApplicationService.getCities();
    }

    @GetMapping("/{id}")
    public CityDto findById(@PathVariable("id") Long id) {
        return cityApplicationService.findById(id);
    }

    @GetMapping("/{city}/city")
    public List<CityDto> findByCity(@PathVariable("city") String city) {
        return cityApplicationService.findByCity(city);
    }

    @GetMapping("/{country}/country")
    public List<CityDto> findByCountry(@PathVariable("country") String country) {
        return cityApplicationService.findByCountry(country);
    }

    @GetMapping("/{state}/state")
    public List<CityDto> findByState(@PathVariable("state") String state) {
        return cityApplicationService.findByState(state);
    }


    @GetMapping("/{country}/country/{state}/state")
    public List<CityDto> findByCountryAndState(@PathVariable("country") String country, @PathVariable("state") String state) {
        return cityApplicationService.findByCountryAndState(country, state);
    }


}
