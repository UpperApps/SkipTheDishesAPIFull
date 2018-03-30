/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.services;

import com.skipthedishes.DTO.CostumerDTO;
import com.skipthedishes.domain.Customer;
import com.skipthedishes.repository.CostumerRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodrigomelo
 */
@Service
public class CustomerService {

    @Autowired
    private CostumerRepository customerRepository;

    public Collection<CostumerDTO> listCostumers() {

        Collection<Customer> customers = customerRepository.findAll();

        Collection<CostumerDTO> customersDTO = new ArrayList<>();

        customers.stream()
                .map(customer -> new CostumerDTO(customer.getId(), customer.getEmail(), customer.getName(),
                customer.getAddress(), customer.getCreation(), customer.getPassword()))
                .forEachOrdered(customerDTO -> customersDTO.add(customerDTO));

        return customersDTO;
    }
}
