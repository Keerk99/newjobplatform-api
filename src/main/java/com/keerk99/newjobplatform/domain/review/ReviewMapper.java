package com.keerk99.newjobplatform.domain.review;

public class ReviewMapper {
    public static Review toReview(CreateReview createReview) {
        Review review = new Review();
        review.setTitle(createReview.title());
        review.setDescription(createReview.description());
        review.setRating(createReview.rating());

        return review;
    }

    public static DataListReview toDataListReview(Review review) {
        return new DataListReview(review);
    }

    public static void toReviewUpdate(UpdateReview updateReview, Review review) {
        review.setTitle(updateReview.title());
        review.setDescription(updateReview.description());
        review.setRating(updateReview.rating());
    }
}
