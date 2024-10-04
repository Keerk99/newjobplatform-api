package com.keerk99.newjobplatform.domain.review;

public record DataListReview(
        Long id,
        String title,
        String description,
        Double rating
) {
    public DataListReview(Review review) {
        this(review.getId(), review.getTitle(), review.getDescription(), review.getRating());
    }
}
