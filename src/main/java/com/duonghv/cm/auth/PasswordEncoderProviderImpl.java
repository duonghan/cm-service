package com.duonghv.cm.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderProviderImpl implements PasswordEncoderProvider {

    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder(11);
    }
}
