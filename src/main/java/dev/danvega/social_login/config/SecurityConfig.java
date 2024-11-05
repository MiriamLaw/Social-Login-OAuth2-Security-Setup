package dev.danvega.social_login.config;//package dev.danvega.social_login.config;

//ORIGINAL FROM DAN VEGA OAUTH2 SETUP VIDEO lines 12-27

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
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




// ADDING EXPLICIT URL AUTHORIZATION & REQUEST MATCHING FOR GOOGLE

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
//import java.util.ArrayList;
//import java.util.List;
//import static org.springframework.security.config.Customizer.withDefaults;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {

//    private final OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService;

//    public SecurityConfig(OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService) {
//        this.oAuth2UserService = oAuth2UserService;
//    }

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/", "/login", "/oauth2/authorization/**").permitAll();
//                    auth.requestMatchers("/secured").hasAnyAuthority(
//                            "SCOPE_https://www.googleapis.com/auth/userinfo.email"
//
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





import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collection;
import java.util.stream.Collectors;



//BEST VERSION, WORKS BEST SO FAR, GETS TO "NOT AUTHORIZED PAGE" INSTEAD OF SERVER ERROR LINES 99-131
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/", "/login", "/oauth2/authorization/google").permitAll()
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





//WAS SIMPLEST VERSION POSSIBLE, Tried with Pete, BUT FAILING TO LOAD LOGIN PAGE
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/", "/login", "/oauth2/authorization/google").permitAll()
//                        .requestMatchers("/test", "/secured")
//                        .authenticated()  // Ensure these routes require authentication
//                        .anyRequest().permitAll()
//                )
//                .oauth2Login(withDefaults())  // Replace deprecated methods with defaults where applicable
//                .csrf(csrf -> csrf.disable()); // Disable CSRF for simplicity (optional, based on your needs)
//
//        return http.build();
//    }
//}













