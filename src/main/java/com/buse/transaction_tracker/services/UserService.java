package com.buse.transaction_tracker.services;


import com.buse.transaction_tracker.model.User;

public interface UserService {
    User getUser(String username, String password);
}
