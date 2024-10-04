package com.keerk99.newjobplatform.domain.job;

import com.keerk99.newjobplatform.domain.company.Company;
import jakarta.validation.constraints.NotBlank;

public record CreateJob(
        @NotBlank(message = "Title can't be blank")
        String title,
        String description,
        String minSalary,
        String maxSalary,
        String location,
        Company company
) {
}