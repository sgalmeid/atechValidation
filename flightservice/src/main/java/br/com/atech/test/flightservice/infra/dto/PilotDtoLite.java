package br.com.atech.test.flightservice.infra.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PilotDtoLite {
    private Long id;
    private String name;
}
