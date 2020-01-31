package br.com.atech.test.pilotservice.infra.dto.form;

import br.com.atech.test.pilotservice.domain.Adrress;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Embedded;
import java.time.LocalDate;

@Getter
@Builder
public class PilotFormDto {
    private String fisrtName;
    private String lastName;

    private LocalDate birthday;
    private String breve;

    private String city;
    private String strret;

    private String cellNumber;
    private String email;
}
