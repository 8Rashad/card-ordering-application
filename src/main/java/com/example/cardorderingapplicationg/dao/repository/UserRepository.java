package com.example.cardorderingapplicationg.dao.repository;

import com.example.cardorderingapplicationg.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long>, JpaRepository<UserEntity, Long> {
}
