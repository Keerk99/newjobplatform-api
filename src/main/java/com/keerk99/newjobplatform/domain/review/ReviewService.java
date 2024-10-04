package com.keerk99.newjobplatform.domain.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewService {
    Page<DataListReview> getReviews(Long companyId, Pageable pageable);
    void addReview(Long companyId, CreateReview createReview);
    DataListReview findReviewBydId(Long companyId, Long reviewId);
    void updateReview(Long companyId, Long reviewId, UpdateReview updateReview);
    void deleteReview(Long companyId, Long reviewId);
}
