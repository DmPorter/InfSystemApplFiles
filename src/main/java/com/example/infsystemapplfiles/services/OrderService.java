package com.example.infsystemapplfiles.services;

import com.example.infsystemapplfiles.models.Order;
import com.example.infsystemapplfiles.models.OrderPosition;
import com.example.infsystemapplfiles.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final OrderRepository orderRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository, ProductRepository productRepository,
                        OrderPositionRepository orderPositionRepository,
                        AdditiveOrderPositionRepository additiveOrderPositionRepository,
                        PersonRepository personRepository) {
        this.orderRepository = orderRepository;

    }


    public List<Order> getOrdersByDate(Timestamp from, Timestamp to){
        List<Order> orders = orderRepository.findAll();

        orders.removeIf((a) -> !from.before(a.getDate()) || !to.after(a.getDate()));

        return orders;
    }
}
