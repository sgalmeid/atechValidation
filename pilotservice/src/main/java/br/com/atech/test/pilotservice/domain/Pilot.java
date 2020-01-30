package br.com.atech.test.pilotservice.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
public class Pilot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, insertable = false, updatable = false)
    private Long id;

    private String fisrtName;
    private String lastName;

    private LocalDate birthday;
    private String breve;

    @Embedded
    private Adrress adrress;

    private String cellNumber;
    private String email;

    public Pilot(){}

    public Pilot(String fisrtName, String lastName, LocalDate birthday,
                 String breve, String cityName, String street, String cellNumber,
                 String email) {
        this(fisrtName,lastName,birthday,breve,
                new Adrress(cityName,street),cellNumber,email);
    }

    public Pilot(String fisrtName, String lastName, LocalDate birthday,
                 String breve, Adrress adrress, String cellNumber,
                 String email) {
        update(fisrtName, lastName, birthday, breve, adrress, cellNumber, email);
    }

    private void update(String fisrtName, String lastName, LocalDate birthday, String breve, Adrress adrress, String cellNumber, String email) {
        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.breve = breve;
        this.adrress = adrress;
        this.cellNumber = cellNumber;
        this.email = email;
    }
}
