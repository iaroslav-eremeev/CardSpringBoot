package com.iaroslaveremeev.controllers;

import com.iaroslaveremeev.model.User;
import com.iaroslaveremeev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> checkLogin(@RequestParam("login") String login, @RequestParam("password") String password) {
        boolean isValidLogin = userService.checkLogin(login, password.toCharArray());
        if (isValidLogin) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid login credentials");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestParam("name") String name,
                                          @RequestParam("login") String login,
                                          @RequestParam("password") String password,
                                          @RequestParam("email") String email) {
        try {
            char[] passwordChars = password.toCharArray();
            User user = new User();
            user.setName(name);
            user.setLogin(login);
            user.setPassword(passwordChars);
            user.setEmail(email);
            this.userService.addUser(user);
            // Clear the password array after use
            Arrays.fill(passwordChars, ' ');
            return ResponseEntity.ok("User added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add user");
        }
    }

}
