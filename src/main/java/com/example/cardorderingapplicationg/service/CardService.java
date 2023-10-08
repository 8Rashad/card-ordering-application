package com.example.cardorderingapplicationg.service;

import com.example.cardorderingapplicationg.dao.entity.CardEntity;
import com.example.cardorderingapplicationg.mapper.CardMapper;
import com.example.cardorderingapplicationg.model.CardRequest;
import com.example.cardorderingapplicationg.dao.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    public void createCard(CardRequest cardRequest){

        cardRepository.save(CardMapper.mapToCardEntity(cardRequest));
    }
    public List<CardEntity> getAllCards(){
        return cardRepository.findAll();
    }
    public CardEntity getCardById(Long id){

        return cardRepository.findById(id).orElse(null);
    }

    public CardEntity updateCard(Long id, String pan, String cvv, String cardHolder, String expirationDate){
        CardEntity existingCard = cardRepository.findById(id).orElse(null);
        if (existingCard != null){
            existingCard.setPan(pan);
            existingCard.setCvv(cvv);
            existingCard.setCardHolder(cardHolder);
            existingCard.setExpirationDate(expirationDate);
            return cardRepository.save(existingCard);
        }
        return null;
    }

    private CardEntity fetchCardIfExist(Long id) {
        return cardRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("ActionLog.getCustomer.error id:{}", id);
                    throw new NotFoundException("CARD_NOT_FOUND");
                });
    }

    public boolean deleteCard(Long id) {
        CardEntity existingCard = cardRepository.findById(id).orElse(null);
        if (existingCard != null) {
            cardRepository.delete(existingCard);
            return true;
        }
        return false;
    }
    public CardEntity getCardByUserId(Long userId){

        return cardRepository.findById(userId).orElse(null);
    }
}
