package com.dreamchain.skeleton.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by przemek on 2014-10-29.
 */
@Entity
@Table(name = "COUNTRIES", schema = "HR")
public class Country {
    @Size(min = 2, max = 2, message = "Kod kraju musi być dwuliterowy")
    private String countryId;

    @Size(min = 1, max = 5, message = "Od 1 do 5 znaków")
    private String name;

    private Region region;

    @Id
    @Column(name = "COUNTRY_ID", length = 2, nullable = false, columnDefinition = "char(2)")
    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @ManyToOne(targetEntity = Region.class)
    @JoinColumn(name = "REGION_ID")
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
    @Column(name = "COUNTRY_NAME", length = 40, nullable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
