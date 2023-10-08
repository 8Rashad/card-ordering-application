package com.example.cardorderingapplicationg.service;

import com.example.cardorderingapplicationg.controller.TicketController;
import com.example.cardorderingapplicationg.dao.entity.TicketEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketController ticketController;

    public void createTicketForOrder(Long orderId) {

        ticketController.createTicket(orderId, new TicketEntity());
    }

}
