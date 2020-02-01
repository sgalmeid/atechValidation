package br.com.atech.test.aircraftservice.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, insertable = false, updatable = false)
    private Long id;

    private String name;

    public Aircraft(){}

    public Aircraft(String name){
        this.name = name;
    }

}
