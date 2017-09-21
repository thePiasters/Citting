package com.citting.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true,nullable = false)
    private String login;

    @NotEmpty
    private String password;

    //@Pattern(regexp = "[A-Za-z]+")
    @NotEmpty
    private String firstName;

   // @Pattern(regexp = "[A-Za-z]+")
    @NotEmpty
    private String lastName;

    @Email
    @Column(unique=true,nullable = false)
    private String email;

    private String answear;




    @ManyToOne(cascade= {CascadeType.MERGE})
    @JoinColumn(name = "question_id")
    private Question question;


    public List<UserPlace> getUserplace() {
        return userplace;
    }

    public void setUserplace(List<UserPlace> userplace) {
        this.userplace = userplace;
    }

    @OneToMany(cascade= {CascadeType.REMOVE},fetch	=	FetchType.EAGER)
    private List<UserPlace> userplace=new ArrayList<>();







    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswear() {
        return answear;
    }

    public void setAnswear(String answear) {
        this.answear = answear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String logIn) {
        this.login = logIn;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
