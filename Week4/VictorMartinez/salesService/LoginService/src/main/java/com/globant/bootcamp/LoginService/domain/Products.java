package com.globant.bootcamp.LoginService.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Products implements Serializable {


    @Id
    @GeneratedValue
    private Long id;

    private String brand;

    private String category;

    private String enterprise;

    private String expirationDate;

    private String name;

    private String price;

    private String productionDate;

    private String reference;

    public Products() {}

    public Products(

            String brand, String category, String enterprise, String expirationDate,
            String name, String price, String productionDate, String reference) {

        super();
        this.brand = brand;
        this.category = category;
        this.enterprise = enterprise;
        this.expirationDate = expirationDate;
        this.name = name;
        this.price = price;
        this.productionDate = productionDate;
        this.reference = reference;

    }

    public Products(String brand, String category, String enterprise, String name, String price) {
        this.brand = brand;
        this.category = category;
        this.enterprise = enterprise;
        this.expirationDate = null;
        this.name = name;
        this.price = price;
        this.productionDate = null;
        this.reference = null;
    }

    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
