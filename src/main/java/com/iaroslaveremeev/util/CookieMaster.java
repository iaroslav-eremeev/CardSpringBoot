package com.iaroslaveremeev.util;

import javax.servlet.http.Cookie;

public class CookieMaster {
    public static Cookie createCookie(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60); // 1 hour
        return cookie;
    }
}
