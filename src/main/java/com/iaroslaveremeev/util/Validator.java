package com.iaroslaveremeev.util;

import java.util.regex.Pattern;

public class Validator {
    public boolean isValidName(String name) {
        // Only Latin letters, hyphens, and blank spaces
        String pattern = "^[A-Za-z\\s\\-]+$";
        return Pattern.matches(pattern, name);
    }

    public boolean isValidLogin(String login) {
        // Only letters and numbers, at least one letter
        String pattern = "^(?=.*[a-zA-Z])[a-zA-Z0-9]+$";
        return Pattern.matches(pattern, login);
    }

    public boolean isValidEmail(String email) {
        // Email format
        String pattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(pattern, email);
    }

    public boolean isValidPassword(String password) {
        // At least one letter and one number
        String pattern = "^(?=.*[a-zA-Z])(?=.*\\d).+$";
        return Pattern.matches(pattern, password);
    }
}
