package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserAddressResponseModel getUserAddress(String id) {
        Optional<UserEntity> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            UserAddressResponseModel response = new UserAddressResponseModel();
            response.setAddress(userOpt.get().getAddress());
            return response;
        }
        throw new UserNotFoundException(id);
    }

}
