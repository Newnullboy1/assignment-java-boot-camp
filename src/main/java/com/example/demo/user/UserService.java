package com.example.demo.user;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Setter
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

    public UserEntity getUserById(String id) {
        Optional<UserEntity> userOpt = userRepository.findById(id);

        if (userOpt.isPresent()) {
            return userOpt.get();
        }
        throw new UserNotFoundException(id);
    }
}
