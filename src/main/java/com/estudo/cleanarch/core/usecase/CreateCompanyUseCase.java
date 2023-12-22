package com.estudo.cleanarch.core.usecase;

import com.estudo.cleanarch.core.domain.Company;
import com.estudo.cleanarch.core.ports.CompanyRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class CreateCompanyUseCase {
    private CompanyRepositoryPort companyRepositoryPort;

    public Optional<Company> create(Company company) {

        var newCompany = companyRepositoryPort.saveOrUpdate(company);

        return newCompany;
    }
}
