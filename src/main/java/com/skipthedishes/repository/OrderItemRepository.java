/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.repository;

import com.skipthedishes.domain.OrderItem;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rodrigomelo
 */
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
    
}
