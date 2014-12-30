package com.dreamchain.skeleton.model;

import com.dreamchain.skeleton.model.Country;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by przemek on 2014-10-29.
 */

@Entity
@Table(name = "REGIONS", schema = "HR")
public class Region {

    private Integer id;


    private String name;


    private List<Country> countries = new ArrayList<Country>();

    @Id
    @Column(name="REGION_ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name="REGION_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @OneToMany
    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
