package com.estudo.cleanarch.core.usecase;

import com.estudo.cleanarch.core.domain.Company;
import com.estudo.cleanarch.core.ports.CompanyRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class DeleteCompanyUseCase {

    private CompanyRepositoryPort companyRepositoryPort;

    public Optional<Company> delete(String document) {
        var doc = Long.parseLong(document);

        var company = companyRepositoryPort.findByDocument(doc);

        companyRepositoryPort.delete(doc);

        return company;
    }
}
