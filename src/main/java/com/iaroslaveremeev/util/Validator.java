package com.iaroslaveremeev.util;

import java.util.regex.Pattern;

public class Validator {
    public static String validateRegistrationFields(String name, String login,
                                                    String password, String email){
        if (name.length() == 0 || login.length() == 0
                || password.length() == 0 || email.length() == 0){
            return "Invalid input: one or more parameters are empty";
        }
        if (!isValidName(name)) {
            return "Invalid name format: only letters are allowed";
        }
        if (!isValidLogin(login)) {
            return "Invalid login format: only letters and numbers are allowed";
        }
        if (!isValidEmail(email)) {
            return "Invalid email format";
        }
        if (!isValidPassword(password)) {
            return "Invalid password format: at least one letter and one number are needed";
        }
        return null; // Return null if everything is OK
    }

    public static boolean isValidName(String name) {
        // Only Latin letters, hyphens, and blank spaces
        String pattern = "^[A-Za-z\\s\\-]+$";
        return Pattern.matches(pattern, name);
    }

    public static boolean isValidLogin(String login) {
        // Only letters and numbers, at least one letter
        String pattern = "^(?=.*[a-zA-Z])[a-zA-Z0-9]+$";
        return Pattern.matches(pattern, login);
    }

    public static boolean isValidEmail(String email) {
        // Email format
        String pattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(pattern, email);
    }

    public static boolean isValidPassword(String password) {
        // At least one letter and one number
        String pattern = "^(?=.*[a-zA-Z])(?=.*\\d).+$";
        return Pattern.matches(pattern, password);
    }
}
