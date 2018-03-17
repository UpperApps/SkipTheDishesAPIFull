/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.resources;

import com.skipthedishes.DTO.ProductDTO;
import com.skipthedishes.services.ProductService;
import java.util.List;
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
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 *
 * @author rodrigomelo
 */
@RestController
@RequestMapping("/api/v1/Product")
public class ProductResource {
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<ProductDTO>> list(){

            List<ProductDTO> products = productService.listProducts();

            return ResponseEntity.status(HttpStatus.OK).body(products);
    }
    
    @RequestMapping(value = "/{id}", method = GET)
    public Object get(@PathVariable String id) {
        return null;
    }
    
    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    
    @RequestMapping(value = "/{id}", method = POST)
    public ResponseEntity<?> post(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    
    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<Object> delete(@PathVariable String id) {
        return null;
    }
    
}
