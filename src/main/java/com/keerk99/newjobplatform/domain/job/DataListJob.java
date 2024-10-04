package com.keerk99.newjobplatform.domain.job;

import com.keerk99.newjobplatform.domain.company.Company;
import com.keerk99.newjobplatform.domain.company.DataListCompany;

public record DataListJob(
        Long id,
        String title,
        String description,
        String minSalary,
        String maxSalary,
        String location,
        DataListCompany dataListCompany
) {
    public DataListJob(Job job) {

        this(job.getId(), job.getTitle(), job.getDescription(),
                job.getMinSalary(), job.getMaxSalary(), job.getLocation(),
                createDataListCompany(job.getCompany()));
    }

    private static DataListCompany createDataListCompany(Company company) {
        return company != null ? new DataListCompany(company) : null;
    }
}
