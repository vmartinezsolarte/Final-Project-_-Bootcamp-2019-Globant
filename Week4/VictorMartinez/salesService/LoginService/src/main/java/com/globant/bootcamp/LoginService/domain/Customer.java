package com.globant.bootcamp.LoginService.domain;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Document(collection="customer")
public class Customer implements Serializable {



        @Id
        @NotNull
        @ApiModelProperty(notes = "Id of Customer",name="customerID",required=true,value="test CustomerID")
        private long id;

        @NotNull
        @ApiModelProperty(notes = "Firstname of Customer",name="customerFirstname",required=true,value="test CustomerFirstname")
        private String firstname;

        @NotNull
        @ApiModelProperty(notes = "Lastname of Customer",name="customerLastname",required=true,value="test CustomerLastname")
        private String lastname;


        @ApiModelProperty(notes = "Age of Customer",name="customerAge", value="test CustomerAge")
        private String age;


        @ApiModelProperty(notes = "Sex of the Customer",name="customerSex", value="test CustomerSex")
        private String sex;

        @NotNull
        @ApiModelProperty(notes = "Telephone from the Customer",name="customerTelephone",required=true,value="test CustomerTelephone")
        private String telephone;

        @NotNull
        @ApiModelProperty(notes = "Email of the Customer",name="customerEmail",required=true,value="test CustomerEmail")
        private String email;

        @NotNull
        @ApiModelProperty(notes = "Address of the Customer",name="customerAddress",required=true,value="test CustomerAddress")
        private String address;

        @NotNull
        @ApiModelProperty(notes = "Subscription date of the Customer",name="customerInitialDate",required=true,value="test CustomerInitialDate")
        private String dateInitial;

        @NotNull
        @ApiModelProperty(notes = "username of Customer",name="customerUsername",required=true,value="test CustomerUsername")
        private String username;

        @NotNull
        @ApiModelProperty(notes = "Password of Customer",name="customerPassword",required=true,value="test CustomerPassword")
        private String password;


        @ApiModelProperty(notes = "Products of the Customer",name="customerProducts",required=true,value="test CustomerProduct")
        @ElementCollection(targetClass = Products.class)
        @CollectionTable(
                name="products",
                joinColumns =@JoinColumn(name = "id", referencedColumnName = "id")
        )
        private List<Products> products;


        public Customer() {
        }

    public Customer(
            long id, String firstname, String lastname, String age, String sex,
            String telephone, String email, String address, String dateInitial,
            String username, String password, ArrayList<Products> products
    ) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.sex = sex;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.dateInitial = dateInitial;
        this.username = username;
        this.password = password;
        this.products = products;
    }

    public Customer(
            long id, String firstname, String lastname, String age,
            String email, String address, String username, String password
    ) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.sex = "M";
        this.telephone="000-0000-0000";
        this.email = email;
        this.address = address;
        this.dateInitial=null;
        this.username = username;
        this.password = password;
        this.products=null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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

    public String getPassword() { return password; }

    public long get_id() { return id; }

    public void set_id(long _id) { this.id = _id; }

    public String getfirstname() { return firstname; }

    public void setfirstname(String firstname) { this.firstname = firstname;}

    public String getLastname() { return lastname;}

    public void setLastname(String lastname) { this.lastname = lastname; }

    public List<Products> getproducts() { return products; }

    public void setproducts(List<Products> products) { this.products = products; }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
        public String toString() {
            return String.format("Customer[id=%d, firstname='%s', lastName='%s']", id, firstname, lastname);
        }
}
