package com.buse.transaction_tracker.services.impl;

import com.buse.transaction_tracker.model.User;
import com.buse.transaction_tracker.repository.UserRepository;
import com.buse.transaction_tracker.services.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(String username, String password) {

        User getStoreUser = userRepository.getUserByUsernameAndPassword();

        if (getStoreUser.getUsername().equals(username) && getStoreUser.getPassword().equals(password)) {
            return getStoreUser;
        } else {
            throw new RuntimeException("Could not find the user");
        }
    }
}
