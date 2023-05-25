package com.iaroslaveremeev.util;

import com.iaroslaveremeev.model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptMaster {
    public static String encryptUserPassword(User user, String password) throws NoSuchAlgorithmException {
        // Combine salt and password
        byte[] salt = user.getSalt();
        byte[] saltedPassword = new byte[salt.length + password.getBytes().length];
        System.arraycopy(salt, 0, saltedPassword, 0, salt.length);
        System.arraycopy(password.getBytes(), 0, saltedPassword,
                salt.length, password.getBytes().length);
        // Hash the salted password using SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = digest.digest(saltedPassword);
        // Convert the hashed bytes to a hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashedBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
