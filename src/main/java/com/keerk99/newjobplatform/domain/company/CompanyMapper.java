package com.keerk99.newjobplatform.domain.company;

public class CompanyMapper {
    public static Company toCompany(CreateCompany createCompany) {
        Company company = new Company();
        company.setName(createCompany.name());
        company.setDescription(createCompany.description());

        return company;
    }

    public static DataListCompany toDataListCompany(Company company) {
        return new DataListCompany(company);
    }

    public static void toCompanyUpdate(UpdateCompany updateCompany, Company company) {
        company.setName(updateCompany.name());
        company.setDescription(updateCompany.description());
    }
}