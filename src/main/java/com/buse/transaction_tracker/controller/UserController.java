package com.buse.transaction_tracker.controller;

import com.buse.transaction_tracker.model.User;
import com.buse.transaction_tracker.services.impl.UserServiceImpl;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


//    @Operation(summary ="Log in a user")
//    @ApiResponses({
//            @ApiResponse(responseCode = "200", description = "Login successful"),
//            @ApiResponse(responseCode = "208", description = "Log in failed"),
//    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Object> login(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.getUser(user.getUsername(), user.getPassword()),
                    HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.valueOf(208));
        }
    }
}
