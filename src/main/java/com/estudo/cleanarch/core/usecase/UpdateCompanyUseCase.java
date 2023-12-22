package com.estudo.cleanarch.core.usecase;


import com.estudo.cleanarch.core.domain.Company;
import com.estudo.cleanarch.core.exceptions.NotFoundException;
import com.estudo.cleanarch.core.ports.CompanyRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UpdateCompanyUseCase {

    private final CompanyRepositoryPort companyRepositoryPort;

    public Optional<Company> execute(String document, Company company) {

        var actual = companyRepositoryPort.findByDocument(Long.parseLong(document))
                .orElseThrow(NotFoundException::new);

        var alterCompany = Company
                .builder()
                .name(company.getName())
                .fundationDate(company.getFundationDate())
                .cnpj(actual.getCnpj())
                .build();

        var updateCompany = companyRepositoryPort.saveOrUpdate(alterCompany);

        return updateCompany;
    }
}
