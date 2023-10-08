package com.example.cardorderingapplicationg.service;

import com.example.cardorderingapplicationg.dao.entity.OrderEntity;
import com.example.cardorderingapplicationg.dao.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderEntity getOrderByUserId(Long userId){

        return orderRepository.findById(userId).orElse(null);
    }

}
