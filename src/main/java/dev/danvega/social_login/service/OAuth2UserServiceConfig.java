package dev.danvega.social_login.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//@Configuration
//public class OAuth2UserServiceConfig {
//
//    @Bean
//    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService() {
//        DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
//        return userRequest -> {
//            OAuth2User oAuth2User = delegate.loadUser(userRequest);
//
//            // Add default ROLE_USER or any custom role
//            List<GrantedAuthority> authorities = new ArrayList<>(oAuth2User.getAuthorities());
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//
//            // Determine the registrationId (google or github)
//            String registrationId = userRequest.getClientRegistration().getRegistrationId();
//            String userNameAttributeName;
//
//            // Use "sub" for Google, "id" for GitHub
//            if (registrationId.equals("google")) {
//                userNameAttributeName = "sub";
//            } else if (registrationId.equals("github")) {
//                userNameAttributeName = "id";
//            } else {
//                throw new IllegalArgumentException("Unsupported provider: " + registrationId);
//            }
//
//            return new DefaultOAuth2User(authorities, oAuth2User.getAttributes(), userNameAttributeName);
//        };
//    }
//}

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.List;

//@Configuration
//public class OAuth2UserServiceConfig {
//
//    @Bean
//    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService() {
//        DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
//        return userRequest -> {
//            OAuth2User oAuth2User = delegate.loadUser(userRequest);
//            List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));
//            return new DefaultOAuth2User(authorities, oAuth2User.getAttributes(), "sub"); // Use "sub" as Google’s identifier
//        };
//    }
//}


@Configuration
public class OAuth2UserServiceConfig {

//    @Bean
//    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService() {
//        DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
//        return userRequest -> {
//            OAuth2User oAuth2User = delegate.loadUser(userRequest);
//            System.out.println("OAuth2 User Authorities: " + oAuth2User.getAuthorities());
//            // Keep the original authorities (SCOPE_*, OIDC_USER)
//            Collection<? extends GrantedAuthority> authorities = oAuth2User.getAuthorities();
//            System.out.println("OAuth2 User Authorities: " + authorities);
//            return new DefaultOAuth2User(authorities, oAuth2User.getAttributes(), "sub"); // Use "sub" as Google’s identifier
//        };
//    }

    @Bean
    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService() {
        DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
        return userRequest -> {
            OAuth2User oAuth2User = delegate.loadUser(userRequest);
            Collection<GrantedAuthority> mappedAuthorities = new ArrayList<>(oAuth2User.getAuthorities());

            // Add custom roles or scopes if needed
//            mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_GOOGLE_OIDC_USER"));
            mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

            System.out.println("OAuth2 User Authorities: " + mappedAuthorities);

            return new DefaultOAuth2User(mappedAuthorities, oAuth2User.getAttributes(), "sub");
        };
    }

}






