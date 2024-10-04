package com.keerk99.newjobplatform.domain.company.impl;

import com.keerk99.newjobplatform.domain.company.*;
import com.keerk99.newjobplatform.infra.errors.Validation;
import com.keerk99.newjobplatform.domain.job.JobRepository;
import com.keerk99.newjobplatform.domain.review.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ReviewRepository reviewRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository, ReviewRepository reviewRepository, JobRepository jobRepository) {
        this.companyRepository = companyRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Page<DataListCompany> findAll(Pageable pageable) {
        Page<DataListCompany> companies = companyRepository.findAll(pageable)
                .map(CompanyMapper::toDataListCompany);
        if (!companies.hasContent()) {
            throw new Validation("No companies found");
        }
        return companies;
    }

    @Override
    public void createCompany(CreateCompany createCompany) {
        Company company = CompanyMapper.toCompany(createCompany);
        companyRepository.save(company);
    }

    @Override
    public DataListCompany findCompanyById(Long companyId) {
        return companyRepository.findById(companyId)
                .map(CompanyMapper::toDataListCompany)
                .orElseThrow(()->
                        new EntityNotFoundException("Company with ID " + companyId + " not found."));
    }

    @Override
    public Company getCompanyEntityById(Long companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() ->
                        new DataIntegrityViolationException("Company with ID " + companyId + " not found."));
    }

    @Transactional
    @Override
    public void updateCompany(Long companyId, UpdateCompany updateCompany) {
        Company companyToUpdate = companyRepository.findById(companyId)
                .orElseThrow(()->
                        new EntityNotFoundException("Company with ID " + companyId
                                + " not found."));

        CompanyMapper.toCompanyUpdate(updateCompany, companyToUpdate);
        companyRepository.save(companyToUpdate);
    }

    @Transactional
    @Override
    public void deleteCompany(Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(()->
                        new EntityNotFoundException("Company with ID " + companyId + " not found."));

        reviewRepository.deleteByCompanyId(company.getId());
        companyRepository.deleteById(company.getId());
    }
}
