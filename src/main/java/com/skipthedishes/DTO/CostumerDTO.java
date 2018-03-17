/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.DTO;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rodrigomelo
 */
@XmlRootElement
public class CostumerDTO {

    private Integer id;
    private String email;
    private String name;
    private String address;
    private Date creation;
    private String password;

    public CostumerDTO(Integer id, String email, String name, String address, Date creation, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.address = address;
        this.creation = creation;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
