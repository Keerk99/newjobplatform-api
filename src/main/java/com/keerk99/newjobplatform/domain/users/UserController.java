package com.keerk99.newjobplatform.domain.users;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody RegisterUser registerUser) {
        userService.createUser(registerUser);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }
}
