package dev.danvega.social_login.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello, home";
    }

    @GetMapping("/secured")
    public String secured(OAuth2AuthenticationToken authentication) {
        System.out.println("Authorities: " + authentication.getAuthorities());
        System.out.println("Final Authorities: " + SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return "securedPage";
    }
}