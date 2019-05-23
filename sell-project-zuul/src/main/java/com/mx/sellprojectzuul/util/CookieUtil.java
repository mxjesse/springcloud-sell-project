package com.mx.sellprojectzuul.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author mx
 * @date 2019/5/22 3:15 PM
 */
public class CookieUtil {

    /**
     * 设置response的cookie
     *
     * @param response
     * @param name
     * @param value
     * @param maxAge
     * @return
     */
    public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {

        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    public static Cookie getCookie(HttpServletRequest request, String name) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
