package com.estudo.cleanarch.services;

import com.estudo.cleanarch.dtos.UserDto;
import com.estudo.cleanarch.models.UserModel;
import com.estudo.cleanarch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(UserDto userDto) {
        UserModel userModel = new UserModel();

        userModel.setName(userDto.getName());
        userModel.setLastName(userDto.getLastName());

        userRepository.save(userModel);

    }

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }
}
