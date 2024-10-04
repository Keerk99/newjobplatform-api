package com.keerk99.newjobplatform.domain.company;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyService {
    Page<DataListCompany> findAll(Pageable pageable);
    void createCompany(CreateCompany company);
    DataListCompany findCompanyById(Long companyId);
    Company getCompanyEntityById(Long companyId);
    void updateCompany(Long companyId, UpdateCompany company);
    void deleteCompany(Long companyId);
}
