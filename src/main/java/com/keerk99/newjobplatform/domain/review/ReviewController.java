package com.keerk99.newjobplatform.domain.review;

import com.keerk99.newjobplatform.response.PaginatedResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/companies/{companyId}/reviews")
@AllArgsConstructor
@SecurityRequirement(name = "bearer-key")
public class ReviewController {

    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<PaginatedResponse<DataListReview>> getReviews(@PageableDefault(size = 10) Pageable pageable,
                                                                        @PathVariable Long companyId) {
        String baseUrl = "/companies/" + companyId + "/reviews";
        Page<DataListReview> reviewPage = reviewService.getReviews(companyId, pageable);
        PaginatedResponse<DataListReview> response = new PaginatedResponse<>(reviewPage, baseUrl);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createReview(@PathVariable Long companyId,
                                               @Valid @RequestBody CreateReview createReview) {
        reviewService.addReview(companyId, createReview);
        return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<DataListReview> getReviewById(@PathVariable Long companyId,
                                                        @PathVariable Long reviewId) {
        DataListReview review = reviewService.findReviewBydId(companyId, reviewId);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId,
                                               @Valid @RequestBody UpdateReview updateReview) {
        reviewService.updateReview(companyId, reviewId, updateReview);
        return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId) {
            reviewService.deleteReview(companyId, reviewId);
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
    }
}
