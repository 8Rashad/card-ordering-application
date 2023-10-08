package com.example.cardorderingapplicationg.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardRequest {
    private String pan;

    private String cvv;

    private String cardHolder;

    private String expirationDate;

    private Long userId;
}
