package com.glb.bootcamp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerEntity {

    @Id
    private Long id;

    @Column(name="first_name")
    private String name;

    @Column(name="last_name")
    private String surname;


    @Column(name="user_name")
    private String username;

    @Column(name="user_password")
    private String password;

    public CustomerEntity(){}

    public CustomerEntity(Long id, String name, String surname) {
        super();
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password;}

    public void setPassword(String password) {this.password = password;}
}
