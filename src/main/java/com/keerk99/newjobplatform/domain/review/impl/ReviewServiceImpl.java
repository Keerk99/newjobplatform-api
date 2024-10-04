package com.keerk99.newjobplatform.domain.review.impl;

import com.keerk99.newjobplatform.domain.company.Company;
import com.keerk99.newjobplatform.domain.company.CompanyService;
import com.keerk99.newjobplatform.domain.review.*;
import com.keerk99.newjobplatform.infra.errors.Validation;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public Page<DataListReview> getReviews(Long companyId, Pageable pageable) {
        Page<DataListReview> reviews = reviewRepository.findByCompanyId(companyId, pageable)
                .map(ReviewMapper::toDataListReview);
        if (!reviews.hasContent()) {
            throw new Validation("No reviews found for company id " + companyId);
        }
        return reviews;
    }

    @Override
    public void addReview(Long companyId, CreateReview createReview) {
        Company company = companyService.getCompanyEntityById(companyId);
        Review review = ReviewMapper.toReview(createReview);
        review.setCompany(company);
        reviewRepository.save(review);
    }

    @Override
    public DataListReview findReviewBydId(Long companyId, Long reviewId) {
        return reviewRepository.findByCompanyIdAndId(companyId, reviewId)
                .map(ReviewMapper::toDataListReview)
                .orElseThrow(() ->
                        new EntityNotFoundException("Review not found for company id " + companyId
                                + " and review id " + reviewId));
    }

    @Transactional
    @Override
    public void updateReview(Long companyId, Long reviewId, UpdateReview updateReview) {
        Review reviewToUpdate = reviewRepository.findByCompanyIdAndId(companyId, reviewId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Review not found for company id " + companyId
                                + " and review id " + reviewId));

        ReviewMapper.toReviewUpdate(updateReview, reviewToUpdate);
        reviewRepository.save(reviewToUpdate);
    }

    @Transactional
    @Override
    public void deleteReview(Long companyId, Long reviewId) {
        Review review = reviewRepository.findByCompanyIdAndId(companyId, reviewId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Review not found for company id " + companyId
                                + " and review id " + reviewId));

        reviewRepository.deleteById(review.getId());
    }
}
