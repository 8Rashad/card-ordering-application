package com.example.cardorderingapplicationg.controller;

import com.example.cardorderingapplicationg.dao.entity.CardEntity;
import com.example.cardorderingapplicationg.model.CardRequest;
import com.example.cardorderingapplicationg.dao.repository.CardRepository;
import com.example.cardorderingapplicationg.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cards")
public class CardController {

    private final CardService cardService;
    private final CardRepository cardRepository;


    @GetMapping
    public List<CardEntity> getAllCards(){
        return cardService.getAllCards();
    }

    @GetMapping("/{id}")
    public CardEntity getCardById(@PathVariable Long id){
        return cardService.getCardById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCard(@RequestBody CardRequest cardRequest){
        System.out.println(cardRequest.toString());
        cardService.createCard(cardRequest);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CardEntity> updateCard(@PathVariable Long id, @RequestBody CardEntity updatedCard) {
        return cardRepository.findById(id)
                .map(card -> {
                    card.setCardHolder(updatedCard.getCardHolder());
                    card.setCvv(updatedCard.getCvv());
                    card.setPan(updatedCard.getPan());
                    card.setExpirationDate(updatedCard.getExpirationDate());
                    return ResponseEntity.ok().body(cardRepository.save(card));
                })
                .orElse(ResponseEntity.notFound().build());
    }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCard(@PathVariable Long id){
            return cardRepository.findById(id)
                    .map(card -> {
                        cardRepository.delete(card);
                        return ResponseEntity.ok().<Void>build();
                    })
                    .orElse(ResponseEntity.notFound().build());
        }

    @GetMapping("/user/{userId}")
    public CardEntity getOrdersByUserId(@PathVariable Long userId) {

        return cardService.getCardByUserId(userId);
    }
}
