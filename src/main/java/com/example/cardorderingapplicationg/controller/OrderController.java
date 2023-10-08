package com.example.cardorderingapplicationg.controller;

import com.example.cardorderingapplicationg.dao.entity.OrderEntity;
import com.example.cardorderingapplicationg.service.OrderService;
import com.example.cardorderingapplicationg.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/orders")
public class OrderController {

    private final OrderService orderService;
    private final TicketService ticketService;


    @GetMapping("/user/{userId}")
    public OrderEntity getOrdersByUserId(@PathVariable Long userId) {

        return orderService.getOrderByUserId(userId);
    }

    @PostMapping("/implement/{orderId}")
    public ResponseEntity<OrderEntity> implementOrder(@PathVariable Long orderId) {

        ticketService.createTicketForOrder(orderId);

        return ResponseEntity.ok().build();
    }
}
