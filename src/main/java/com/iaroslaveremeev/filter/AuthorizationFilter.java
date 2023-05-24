package com.iaroslaveremeev.filter;

import com.iaroslaveremeev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(value = "/*", asyncSupported = true)
public class AuthorizationFilter implements Filter {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // This chunk of code helps to register users without logging in
        if(request.getRequestURI().endsWith("/user/add")) {
            filterChain.doFilter(request, response);
            return;
        }

        Cookie[] cookies = request.getCookies();
        String value = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("hash")) {
                    value = cookie.getValue();
                }
            }
        }
        // Request/Redirect URL to Login Servlet
        String loginURI = request.getContextPath() + "/login";
        String registerURI = request.getContextPath() + "/registration";
        // If the session was previously created
        boolean loginRequest = request.getRequestURI().contains(loginURI);
        boolean registerRequest = request.getRequestURI().contains(registerURI);
        boolean hashUpdateRequest = request.getRequestURI().endsWith("/update-hash");
        // If the request came from the login page or the session is not empty, we proceed further
        if (request.getRequestURI().endsWith("js") || loginRequest || registerRequest || hashUpdateRequest
                || (value != null && this.userRepository.getUserByHash(value) != null)) {
            filterChain.doFilter(request, response);
            // If not redirect to login page
        } else {
            response.sendRedirect(loginURI + ".html");
        }
    }

    @Override
    public void destroy() {}
}
