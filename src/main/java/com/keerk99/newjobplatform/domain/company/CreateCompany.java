package com.keerk99.newjobplatform.domain.company;

import jakarta.validation.constraints.NotNull;

public record CreateCompany(
        @NotNull(message = "Name cannot be blank")
        String name,
        String description
) {
}
