package com.keerk99.newjobplatform.domain.company;

import jakarta.validation.constraints.NotBlank;

public record UpdateCompany(
        @NotBlank(message = "Name cannot be blank")
        String name,
        @NotBlank(message = "Description can not be blank")
        String description
) {
}
