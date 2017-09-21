package com.citting.entity;


import javax.persistence.*;


@Entity
public class Place {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;


    private String name;

    @Column(columnDefinition="text")
    private String address;

    @Column(columnDefinition="text")
    private String description;

    private double rate;

    @ManyToOne(cascade = {CascadeType.MERGE})
    Category category;


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // info about latitude & longitude


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
