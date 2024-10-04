package com.keerk99.newjobplatform.domain.company;

import com.keerk99.newjobplatform.domain.review.DataListReview;
import com.keerk99.newjobplatform.domain.review.ReviewMapper;

import java.util.List;
import java.util.stream.Collectors;

public record DataListCompany(
        Long id,
        String name,
        String description,
        List<DataListReview> review
) {
    public DataListCompany(Company company) {
        this(company.getId(), company.getName(), company.getDescription(),
                company.getReviews().stream()
                        .map(ReviewMapper::toDataListReview)
                        .collect(Collectors.toList()));
    }
}
