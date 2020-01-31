package br.com.atech.test.flightservice.infra.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@Getter
@Builder
public class AdrressDto {
    private String cityName;
    private String street;

    public AdrressDto(){}
}
