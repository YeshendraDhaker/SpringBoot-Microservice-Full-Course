package com.shopzone.user_service.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CookieUtil {

    @Value("${jwt.cookie.max-age}")
    private int accessTokenMaxAge;
    @Value("${jwt.refresh-cookie.max-age}")
    private int refreshTokenMaxAge;

    @Value("${jwt.cookie.secure}")
    private boolean secure;

    public void setAccessTokenCookie(HttpServletResponse response, String accessToken) {
        Cookie cookie = createCookie("accessToken", accessToken, accessTokenMaxAge);
        response.addCookie(cookie);
    }

    public void setRefreshTokenCookie(HttpServletResponse response, String accessToken) {
        Cookie cookie = createCookie("refreshToken", accessToken, accessTokenMaxAge);
        response.addCookie(cookie);
    }

    public void deleteAccessTokenCookie(HttpServletResponse response) {
        Cookie cookie = createCookie("accessToken", null, 0);
        response.addCookie(cookie);
    }

    public void deleteRefreshTokenCookie(HttpServletResponse response) {
        Cookie cookie = createCookie("refreshToken", null, 0);
        response.addCookie(cookie);
    }

    //Logout
    public void deleteAllAuthCookies(HttpServletResponse response) {
        deleteAccessTokenCookie(response);
        deleteRefreshTokenCookie(response);
    }


    private Cookie createCookie(String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true); // cannot be accessed by JavaScript(XSS protection)
        cookie.setSecure(true); // Only sent over HTTPS in production
        cookie.setPath("/"); // Avaliable for all paths
        cookie.setMaxAge(maxAge); //Expiry time
        return cookie;
    }
}
