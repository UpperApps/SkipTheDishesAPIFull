/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.services;

import com.skipthedishes.DTO.OrderDTO;
import com.skipthedishes.DTO.OrderItemDTO;
import com.skipthedishes.domain.Customer;
import com.skipthedishes.domain.CustomerOrder;
import com.skipthedishes.domain.OrderItem;
import com.skipthedishes.domain.Product;
import com.skipthedishes.domain.Store;
import com.skipthedishes.repository.ProductRepository;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import com.skipthedishes.repository.CustomerOrderRepository;
import com.skipthedishes.repository.CustomerRepository;
import com.skipthedishes.repository.StoreRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodrigomelo
 */
@Service
public class OrderService {

    @Autowired
    private CustomerOrderRepository costumerOrderRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private StoreRepository storeRepository;

    public CustomerOrder save(OrderDTO orderDTO) {

        CustomerOrder order = new CustomerOrder();
        
        // Load order.
        order.setDate(orderDTO.getDate());
        order.setDeliveryAddress(orderDTO.getDeliveryAddress());
        order.setContact(orderDTO.getContact());
        order.setTotal(orderDTO.getTotal());
        order.setStatus("ordered");
        order.setLastUpdate(Date.valueOf(LocalDate.now()));
        
        Optional<Customer> customer = customerRepository.findById(orderDTO.getCustomerId());
        order.setCustomer(customer.get());
        
        Optional<Store> store = storeRepository.findById(orderDTO.getStoreId());
        order.setStore(store.get());

        
        // TODO As the HELL of the cascade operation didn't work on Hibernate to persist the order items, it's necessary to handle better with transactions here.
        // Save order.
        CustomerOrder customerOrder = costumerOrderRepository.save(order);
        
        // Load the OrderItem list.
        List<OrderItem> orderItemList = orderDTO.getOrderItem().stream()
                .map((OrderItemDTO item) -> {
                    OrderItem orderItem = new OrderItem();

                    orderItem.setPrice(item.getPrice());
                    
                    Optional<Product> product = productRepository.findById(item.getProductId());
                    orderItem.setProduct(product.get());
                    
                    orderItem.setCustomerOrder(customerOrder);
                    orderItem.setQuantity(item.getQuantity());
                    orderItem.setTotal(item.getTotal());

                    return orderItem;
                }).collect(Collectors.toList());
        
                
        customerOrder.setOrderItemList(orderItemList);
        
        costumerOrderRepository.save(customerOrder);
        
        return customerOrder;
    }
}
