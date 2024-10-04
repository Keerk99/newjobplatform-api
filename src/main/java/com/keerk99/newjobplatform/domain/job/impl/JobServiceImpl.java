package com.keerk99.newjobplatform.domain.job.impl;

import com.keerk99.newjobplatform.domain.company.Company;
import com.keerk99.newjobplatform.domain.company.CompanyService;
import com.keerk99.newjobplatform.domain.job.*;
import com.keerk99.newjobplatform.infra.errors.Validation;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final CompanyService companyService;

    public JobServiceImpl(JobRepository jobRepository, CompanyService companyService) {
        this.jobRepository = jobRepository;
        this.companyService = companyService;
    }

    @Override
    public Page<DataListJob> getJobs(Pageable pageable) {
        Page<DataListJob> jobs = jobRepository.findAll(pageable)
                .map(JobMapper::toDataListJob);
        if (!jobs.hasContent()) {
            throw new Validation("No jobs found");
        }
        return jobs;
    }

    @Override
    public void createJob(CreateJob createJob) {

        Long companyId = createJob.company().getId();
        Company company = companyService.getCompanyEntityById(companyId);

        Job job = JobMapper.toJob(createJob);
        job.setCompany(company);
        jobRepository.save(job);
    }

    @Override
    public DataListJob findJobById(Long jobId) {
        return jobRepository.findById(jobId)
                .map(JobMapper::toDataListJob)
                .orElseThrow(() ->
                        new EntityNotFoundException("Job with ID " + jobId + " not found"));
    }

    @Transactional
    @Override
    public void updateJob(Long jobId, UpdateJob updateJob) {
        Job jobToUpdate = jobRepository.findById(jobId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Job with ID " + jobId + " not found"));

        JobMapper.toJobUpdate(updateJob, jobToUpdate);
        jobRepository.save(jobToUpdate);
    }

    @Transactional
    @Override
    public void deleteJob(Long jobId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(()->
                        new EntityNotFoundException("Job with ID " + jobId + " not found"));

        jobRepository.deleteById(job.getId());
    }
}
