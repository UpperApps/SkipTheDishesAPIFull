/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.resources;

import com.skipthedishes.DTO.OrderDTO;
import com.skipthedishes.domain.CustomerOrder;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import com.skipthedishes.repository.CustomerOrderRepository;
import com.skipthedishes.services.OrderService;

/**
 *
 * @author rodrigomelo
 */
@RestController
@RequestMapping("/api/v1/Order")
public class OrderResource {
    
    @Autowired
    private CustomerOrderRepository costumerOrderRepository;
    
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Iterable<CustomerOrder>> list(){

            Iterable<CustomerOrder> costumerOrder = costumerOrderRepository.findAll();

            return ResponseEntity.status(HttpStatus.OK).body(costumerOrder);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Object get(@PathVariable String id) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<CustomerOrder> save(@Valid @RequestBody OrderDTO order) {

        CustomerOrder customerOrder = orderService.save(order);
        return ResponseEntity.status(HttpStatus.OK).body(customerOrder);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<Object> delete(@PathVariable String id) {
        return null;
    }

}
