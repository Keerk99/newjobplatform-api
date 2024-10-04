package com.keerk99.newjobplatform.domain.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    Page<Review> findByCompanyId(Long companyId, Pageable pageable);
    Optional<Review> findByCompanyIdAndId(Long companyId, Long reviewId);
    void deleteByCompanyId(Long companyId);
}
