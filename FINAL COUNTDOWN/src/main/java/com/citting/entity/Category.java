package com.citting.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Pattern(regexp = "[A-Za-z]+")
    String name;

    @OneToMany(fetch = FetchType.EAGER, cascade= {CascadeType.MERGE})

    List<Place> placeList;


   public List<Place> getPlaceList() {
       return placeList;
    }

   public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}
