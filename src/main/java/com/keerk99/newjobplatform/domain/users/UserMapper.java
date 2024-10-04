package com.keerk99.newjobplatform.domain.users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserMapper {
    public static User toUser(RegisterUser registerUser) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(registerUser.password());
        User user = new User();
        user.setUsername(registerUser.username());
        user.setPassword(encodedPassword);
        return user;
    }
}
