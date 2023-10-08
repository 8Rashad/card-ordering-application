package com.example.cardorderingapplicationg.dao.repository;

import com.example.cardorderingapplicationg.dao.entity.OrderEntity;
import com.example.cardorderingapplicationg.dao.entity.TicketEntity;
import com.example.cardorderingapplicationg.enums.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface TicketRepository extends CrudRepository<TicketEntity, Long>, JpaRepository<TicketEntity, Long> {
    List<TicketEntity> findByStatusIn(Collection<TicketStatus> statuses);

}
