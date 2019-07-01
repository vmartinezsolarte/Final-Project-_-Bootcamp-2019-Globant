package com.globant.bootcamp.LoginService.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

        private static final long serialVersionUID = -3009157732242241606L;
        @Id
        @Column(name="id")
        private long id;

        @Column(name = "firstname")
        private String firstName;

        @Column(name = "lastname")
        private String lastName;

        @Column(name = "age")
        private int age;

        @Column(name = "sex")
        private String sex;

        @Column(name = "telephone")
        private String telephone;

        @Column(name = "address")
        private String address;

        @Column(name = "dateInitial")
        private String dateInitial;

        @Column(name = "username")
        private String username;

        @Column(name = "password")
        private String password;

        @Column(name = "firstCategory")
        private String firstCategory;

        @Column(name = "firstProduct")
        private String firstProduct;

        @Column(name = "secondCategory")
        private String secondCategory;

        @Column(name = "secondProduct")
        private String secondProduct;

        protected Customer() {
        }

        public Customer(
                final String firstName,final String lastName,final int age,final String sex,
                final String telephone,final String address, final String dateInitial, final String username,
                final String password, final String firstCategory, final String firstProduct,
                final String secondCategory, final String secondProduct
                ) {
            super();
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.telephone=telephone;
            this.address=address;
            this.dateInitial = dateInitial;
            this.username = username;
            this.password =password;
            this.firstCategory = firstCategory;
            this.firstProduct = firstProduct;
            this.secondCategory= secondCategory;
            this.secondCategory =secondProduct;
        }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateInitial() {
        return dateInitial;
    }

    public void setDateInitial(String dateInitial) {
        this.dateInitial = dateInitial;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstCategory() {
        return firstCategory;
    }

    public void setFirstCategory(String firstCategory) {
        this.firstCategory = firstCategory;
    }

    public String getFirstProduct() {
        return firstProduct;
    }

    public void setFirstProduct(String firstProduct) {
        this.firstProduct = firstProduct;
    }

    public String getSecondCategory() {
        return secondCategory;
    }

    public void setSecondCategory(String secondCategory) {
        this.secondCategory = secondCategory;
    }

    public String getSecondProduct() {
        return secondProduct;
    }

    public void setSecondProduct(String secondProduct) {
        this.secondProduct = secondProduct;
    }

    @Override
        public String toString() {
            return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
        }
}
