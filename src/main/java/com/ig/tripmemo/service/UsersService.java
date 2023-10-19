package com.ig.tripmemo.service;

import com.ig.tripmemo.repository.UsersRepository;
import com.ig.tripmemo.repository.entity.Users;
import com.ig.tripmemo.service.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService {

    private final UsersRepository userRepository;

    @Autowired
    public UsersService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UsersDto> getAllUsers() {
        List<Users> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private UsersDto convertToDTO(Users user) {
        UsersDto userDTO = new UsersDto();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }
}