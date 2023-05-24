package com.iaroslaveremeev.controllers;

import com.iaroslaveremeev.model.User;
import com.iaroslaveremeev.service.UserService;
import com.iaroslaveremeev.util.CookieMaster;
import com.iaroslaveremeev.util.EncryptMaster;
import com.iaroslaveremeev.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> checkLogin(@RequestParam("login") String login,
                                             @RequestParam("password") String password) {
        boolean isValidLogin = userService.checkLogin(login, password.toCharArray());
        if (isValidLogin) {
            User user = this.userService.getUserByLogin(login);
            String hash = EncryptMaster.encryptUserPassword(user, password);
            // Create cookies
            Cookie hashCookie = CookieMaster.createCookie("hash", hash);
            Cookie userIdCookie = CookieMaster.createCookie("userId", String.valueOf(user.getId()));
            Cookie roleCookie = CookieMaster.createCookie("role", user.getRole().name());
            // Add cookies to the response
            HttpServletResponse response = ((ServletRequestAttributes)
                    Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                    .getResponse();
            assert response != null;
            response.addCookie(hashCookie);
            response.addCookie(userIdCookie);
            response.addCookie(roleCookie);
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
            String validationResponse =
                    Validator.validateRegistrationFields(name, login, password, email);
            System.out.println(name);
            System.out.println(login);
            System.out.println(password);
            System.out.println(email);
            System.out.println(validationResponse);
            if (validationResponse != null){
                return ResponseEntity.badRequest().body(validationResponse);
            }
            char[] passwordChars = password.toCharArray();
            User user = new User(login, passwordChars, name, email);
            user.generateSalt();
            // Add user to database
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
