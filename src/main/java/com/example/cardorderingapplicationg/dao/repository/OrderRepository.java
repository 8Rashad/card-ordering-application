package com.example.cardorderingapplicationg.dao.repository;

import com.example.cardorderingapplicationg.dao.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<OrderEntity, Long>, JpaRepository<OrderEntity, Long> {

}
