package com.example.cardorderingapplicationg.mapper;

import com.example.cardorderingapplicationg.dao.entity.UserEntity;
import com.example.cardorderingapplicationg.model.UserRequest;

public class UserMapper {
    public static UserEntity buildUserEntity(UserRequest userRequest){
        return UserEntity.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .build();
    }
}
