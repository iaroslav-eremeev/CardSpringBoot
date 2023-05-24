package com.iaroslaveremeev.util;

import com.iaroslaveremeev.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptMaster {
    public static String encryptUserPassword(User user, String password){
        // Combine salt and password
        byte[] salt = user.getSalt();
        byte[] saltedPassword = new byte[salt.length + password.getBytes().length];
        System.arraycopy(salt, 0, saltedPassword, 0, salt.length);
        System.arraycopy(password.getBytes(), 0, saltedPassword,
                salt.length, password.getBytes().length);
        // Hash the password with the salt
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(new String(saltedPassword));
    }
}
