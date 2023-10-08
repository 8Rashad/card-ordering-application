package com.example.cardorderingapplicationg.mapper;

import com.example.cardorderingapplicationg.dao.entity.CardEntity;
import com.example.cardorderingapplicationg.dao.entity.UserEntity;
import com.example.cardorderingapplicationg.model.CardRequest;

public class CardMapper {

    public static CardEntity mapToCardEntity(CardRequest cardRequest){
        return CardEntity.builder()
                .pan(cardRequest.getPan())
                .cvv(cardRequest.getCvv())
                .cardHolder(cardRequest.getCardHolder())
                .expirationDate(cardRequest.getExpirationDate())
                .user(UserEntity.builder().id(cardRequest.getUserId()).build())
                .build();
    }
}
