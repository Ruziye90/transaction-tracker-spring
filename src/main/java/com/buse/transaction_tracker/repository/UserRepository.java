package com.buse.transaction_tracker.repository;


import com.buse.transaction_tracker.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public User getUserByUsernameAndPassword() {
        return new User("test", "password");
    }
}
