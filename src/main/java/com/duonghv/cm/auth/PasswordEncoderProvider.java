package com.duonghv.cm.auth;

import org.springframework.security.crypto.password.PasswordEncoder;

public interface PasswordEncoderProvider {
    PasswordEncoder getEncoder();
}
