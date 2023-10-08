package com.example.cardorderingapplicationg.dao.repository;

import com.example.cardorderingapplicationg.dao.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<CardEntity, Long>, JpaRepository<CardEntity, Long> {
}
