package com.keerk99.newjobplatform.domain.users;

import jakarta.validation.constraints.NotBlank;

public record RegisterUser(
        @NotBlank(message = "Username can't be blank")
        String username,
        @NotBlank(message = "Password can't be blank")
        String password
) {
}
