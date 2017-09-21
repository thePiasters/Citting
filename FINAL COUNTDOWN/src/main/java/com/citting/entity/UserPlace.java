package com.citting.entity;

import javax.persistence.*;

@Entity
public class UserPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade= {CascadeType.MERGE})
    Place place;

    @ManyToOne(cascade= {CascadeType.MERGE})
    User user;



    boolean history;

    boolean wishList;

    @Column(columnDefinition="text")
    String opinion;

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    double rate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public boolean isWishList() {
        return wishList;
    }

    public void setWishList(boolean wishList) {
        this.wishList = wishList;
    }

    public boolean isHistory() {
        return history;
    }

    public void setHistory(boolean history) {
        this.history = history;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
