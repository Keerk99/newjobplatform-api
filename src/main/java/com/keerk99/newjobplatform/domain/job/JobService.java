package com.keerk99.newjobplatform.domain.job;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobService {
    Page<DataListJob> getJobs(Pageable pageable);
    void createJob(CreateJob createJob);
    DataListJob findJobById(Long jobId);
    void updateJob(Long jobId, UpdateJob updateJob);
    void deleteJob(Long jobId);
}
