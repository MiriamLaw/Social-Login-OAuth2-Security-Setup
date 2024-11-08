package dev.danvega.social_login.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test")
    public String getTestPage() {
        return "test";  // Return the test.html Thymeleaf template
    }
}
