package com.thiagosena.ratelimit.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    public String getUser() {
        var context = SecurityContextHolder.getContext();
        return context.getAuthentication().getName();
    }

    public boolean isAuthenticated() {
        var context = SecurityContextHolder.getContext();

        Authentication authentication = context.getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return false;
        }

        return authentication.isAuthenticated();
    }

    public boolean isNotAuthenticated() {
        return !isAuthenticated();
    }
}
