package com.globant.bootcamp.LoginService.domain;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Products implements Serializable {

    @Id
    @NotNull
    @ApiModelProperty(notes = "Id of the Product",name="ProductID",required=true,value="test ProductID")
    private Long id;

    @NotNull
    @ApiModelProperty(notes = "Brand of the Product",name="ProductBrand",required=true,value="test ProductBrand")
    private String brand;

    @NotNull
    @ApiModelProperty(notes = "Category of the Product",name="ProductCategory",required=true,value="test ProductCategory")
    private String category;

    @NotNull
    @ApiModelProperty(notes = "Producer of the Product",name="ProductEnterprise",required=true,value="test ProductEnterprise")
    private String enterprise;

    @NotNull
    @ApiModelProperty(notes = "Expiration Date of the Product",name="ProductExpirationDate",required=true,value="test ProductExpirationDate")
    private String expirationDate;

    @NotNull
    @ApiModelProperty(notes = "Name of the Product",name="ProductName",required=true,value="test ProductName")
    private String name;

    @NotNull
    @ApiModelProperty(notes = "Price of the Product",name="ProductPrice",required=true,value="test ProductPrice")
    private String price;

    @NotNull
    @ApiModelProperty(notes = "Date of the Product fabrication",name="ProductProductionDate",required=true,value="test ProductProductionDate")
    private String productionDate;


    @ApiModelProperty(notes = "Reference of Product",name="ProductReference",value="test ProductReference")
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
