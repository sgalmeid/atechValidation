package br.com.atech.test.cityservice.domain;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, insertable = false, updatable = false)
    private Long id;

    private String city;

    private String state;

    private String country;

    public City(){}

    public City(String city, String state, String country){
        this.city = city;
    }

}
