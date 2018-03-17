/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.DTO;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rodrigomelo
 */
@XmlRootElement
public class ProductDTO {
    
    private Integer id;
    private String name;
    private String description;
    private double price;
    private Integer storeId;

    public ProductDTO(Integer id, String name, String description, double price, Integer storeId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.storeId = storeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
    
    
    
}
