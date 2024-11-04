package dev.danvega.social_login.config;//package dev.danvega.social_login.config;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    SecurityFilterChain securityFilterChpackage dev.danvega.social_login.config;//package dev.danvega.social_login.config;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.web.SecurityFilterChain;
////
////import static org.springframework.security.config.Customizer.withDefaults;
////
////@Configuration
////@EnableWebSecurity
////public class SecurityConfig {
////
////    @Bean
////    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        return http
////                .authorizeHttpRequests(auth -> {
////                    auth.requestMatchers("/").permitAll();
////                    auth.anyRequest().authenticated();
////                })
////                .oauth2Login(withDefaults())
////                .formLogin(withDefaults())
////                .build();
////    }
////}
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.context.annotation.Bean;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService;
//
//    public SecurityConfig(OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService) {
//        this.oAuth2UserService = oAuth2UserService;
//    }
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
////                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/", "/login", "/oauth2/authorization/**").permitAll();
//                    auth.requestMatchers("/secured").hasAnyAuthority(
//                            "SCOPE_https://www.googleapis.com/auth/userinfo.email",
//                            "SCOPE_read:user"
//                    );
//                    auth.anyRequest().authenticated();
//                })
//                .oauth2Login(oauth2 -> oauth2
//                        .userInfoEndpoint(userInfo -> userInfo
//                                .userService(oAuth2UserService))
//                        .defaultSuccessUrl("/secured", true))  // Add default success URL inside oauth2Login
//                .formLogin(withDefaults())
//                .build();
//    }
//}ain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/").permitAll();
//                    auth.anyRequest().authenticated();
//                })
//                .oauth2Login(withDefaults())
//                .formLogin(withDefaults())
//                .build();
//    }
//}
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.context.annotation.Bean;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService;
//
//    public SecurityConfig(OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService) {
//        this.oAuth2UserService = oAuth2UserService;
//    }
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
////                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/", "/login", "/oauth2/authorization/**").permitAll();
//                    auth.requestMatchers("/secured").hasAnyAuthority(
//                            "SCOPE_https://www.googleapis.com/auth/userinfo.email",
//                            "SCOPE_read:user"
//                    );
//                    auth.anyRequest().authenticated();
//                })
//                .oauth2Login(oauth2 -> oauth2
//                        .userInfoEndpoint(userInfo -> userInfo
//                                .userService(oAuth2UserService))
//                        .defaultSuccessUrl("/secured", true))  // Add default success URL inside oauth2Login
//                .formLogin(withDefaults())
//                .build();
//    }
//}


//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.client.registration.OAuth2UserRequest;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService;
//
//    public SecurityConfig(OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService) {
//        this.oAuth2UserService = oAuth2UserService;
//    }
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/", "/login", "/oauth2/authorization/google").permitAll()
//                        .requestMatchers("/secured").hasRole("USER") // Only authenticated users with role "USER"
//                )
//                .oauth2Login(oauth2 -> oauth2
//                        .userInfoEndpoint(userInfo -> userInfo
//                                .userService(oAuth2UserService)
//                        )
//                )
//                .build();
//    }
//}


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

import java.util.Collection;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login", "/oauth2/authorization/google").permitAll()
                        .requestMatchers("/test").hasRole("USER")  // Ensure only ROLE_USER can access
                        .requestMatchers("/secured").hasRole("USER")
                )
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(userInfo -> userInfo
                                .userAuthoritiesMapper(this::mapGoogleAuthorities)
                        )
                )
                .build();
    }

    // This method maps Google OAuth2 authorities to Spring Security roles
    private Collection<? extends GrantedAuthority> mapGoogleAuthorities(Collection<? extends GrantedAuthority> authorities) {
        return authorities.stream()
                .map(grantedAuthority -> {
                    // Assign a role based on the OIDC user authority or other criteria
                    if (grantedAuthority.getAuthority().equals("OIDC_USER")) {
                        return new SimpleGrantedAuthority("ROLE_USER");  // Map to ROLE_USER
                    }
                    return grantedAuthority;
                })
                .collect(Collectors.toList());
    }
}










