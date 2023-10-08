package com.example.cardorderingapplicationg.controller;


import com.example.cardorderingapplicationg.dao.entity.TicketEntity;
import com.example.cardorderingapplicationg.enums.TicketStatus;
import com.example.cardorderingapplicationg.dao.repository.OrderRepository;
import com.example.cardorderingapplicationg.dao.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.cardorderingapplicationg.enums.TicketStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/tickets")
public class TicketController {
    private final TicketRepository ticketRepository;
    private final OrderRepository orderRepository;

    @PostMapping("/create/orderId")
    public ResponseEntity<TicketEntity> createTicket(@PathVariable Long orderId, @RequestBody TicketEntity ticket) {
        if (!orderRepository.existsById(orderId)) {
            return ResponseEntity.notFound().build();
        }
        ticket.setOrderId(orderId);
        ticket.setStatus(OPEN.name());

    TicketEntity savedTicket = ticketRepository.save(ticket);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedTicket);
    }

    @PutMapping("/{ticketId}/status")
    public ResponseEntity<String> updateTicketStatus(
            @PathVariable Long ticketId,
            @RequestParam TicketStatus newStatus
    ) {
        TicketEntity ticket = ticketRepository.findById(ticketId).orElse(null);
        if (ticket == null) {
            return ResponseEntity.notFound().build();
        }

        if (newStatus == DONE && ticket.getCard() == null) {
            return ResponseEntity.badRequest().body("A card must be created before marking the ticket as" + DONE);
        }

        ticket.setStatus(String.valueOf(newStatus));
        ticketRepository.save(ticket);

        return ResponseEntity.ok(String.valueOf(ticket));
    }


    @GetMapping("/not-ready")
    public List<TicketEntity> getNotReadyTickets() {
        return ticketRepository.findByStatusIn(List.of(OPEN, DONE, IN_PROGRESS));
    }
}
