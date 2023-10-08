package com.example.cardorderingapplicationg.service;

import com.example.cardorderingapplicationg.model.UserRequest;
import com.example.cardorderingapplicationg.mapper.UserMapper;
import com.example.cardorderingapplicationg.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(UserRequest userRequest){
        userRepository.save(UserMapper.buildUserEntity(userRequest));
    }


}
