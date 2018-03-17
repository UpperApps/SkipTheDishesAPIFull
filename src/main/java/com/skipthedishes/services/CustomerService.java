/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.services;

import com.skipthedishes.DTO.CostumerDTO;
import com.skipthedishes.domain.Customer;
import com.skipthedishes.repository.CostumerRepository;
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
    private CostumerRepository costumerRepository;

    public List<CostumerDTO> listCostumers() {
        
        Iterable<Customer> costumers = null;

        costumers = costumerRepository.findAll();

        List<CostumerDTO> costumersDTO = null;

        for (Customer costumer : costumers) {
            CostumerDTO costumerDTO = new CostumerDTO(costumer.getId(), costumer.getEmail(), costumer.getName(),
                    costumer.getAddress(), costumer.getCreation(), costumer.getPassword());
            costumersDTO.add(costumerDTO);
        }

        return costumersDTO;
    }
}
