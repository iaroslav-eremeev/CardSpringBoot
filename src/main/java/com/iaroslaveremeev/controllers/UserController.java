package com.iaroslaveremeev.controllers;

import com.iaroslaveremeev.dto.ResponseResult;
import com.iaroslaveremeev.model.Role;
import com.iaroslaveremeev.model.User;
import com.iaroslaveremeev.service.UserService;
import com.iaroslaveremeev.util.Validator;
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
            if (name.length() == 0 || login.length() == 0
                    || password.length() == 0 || email.length() == 0){
                return ResponseEntity.badRequest().body("Invalid input: one or more parameters are empty");
            }
            Validator validator = new Validator();
            if (!validator.isValidName(name)) {
                return ResponseEntity.badRequest().body("Invalid name format: only letters are allowed");
            }
            if (!validator.isValidLogin(login)) {
                return ResponseEntity.badRequest().body("Invalid login format: only letters and numbers are allowed");
            }
            if (!validator.isValidEmail(email)) {
                return ResponseEntity.badRequest().body("Invalid email format");
            }
            if (!validator.isValidPassword(password)) {
                return ResponseEntity.badRequest().body("Invalid password format: at least one letter and one number are needed");
            }
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
