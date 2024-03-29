package br.com.atech.test.flightservice.infra.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class PilotDto {

    private Long id;
    private String fisrtName;
    private String lastName;

    private String breve;

    private AdrressDto adrress;

    private String cellNumber;
    private String email;

}
