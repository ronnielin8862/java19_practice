package org.example.api.controller.auth;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/auth")

public class Login {

    private static final Logger LOG = LoggerFactory.getLogger(Login.class);

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        LOG.info("=== login === "  + loginRequest.toString());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginRequest.getUsername(), loginRequest.getPassword());
        try {
            subject.login(token);
            subject.hasRole("admin");
            subject.isPermitted("crud");
            return ResponseEntity.ok("Login successful");
        } catch (AuthenticationException e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }

    @PostMapping("/status")
    public ResponseEntity<String> checkAuthenticationStatus(HttpServletRequest request) {
        LOG.debug("getCookies:" + request.getCookies());
        Subject currentUser = SecurityUtils.getSubject();
        LOG.debug("currentUser = "  + currentUser.toString());
        if (currentUser.isAuthenticated()) {
            return ResponseEntity.ok("Authenticated");
        } else {
            return ResponseEntity.ok("Not Authenticated");
        }
    }
}

class LoginRequest {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    // getters and setters
}