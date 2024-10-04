package com.keerk99.newjobplatform.domain.job;

import jakarta.validation.constraints.NotBlank;

public record UpdateJob(
        @NotBlank(message = "Title can't be blank")
        String title,
        @NotBlank(message = "Description can't be blank")
        String description,
        String minSalary,
        String maxSalary,
        String location
) {
}
