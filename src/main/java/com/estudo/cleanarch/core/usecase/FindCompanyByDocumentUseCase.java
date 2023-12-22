package com.estudo.cleanarch.core.usecase;

import com.estudo.cleanarch.core.domain.Company;
import com.estudo.cleanarch.core.ports.CompanyRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class FindCompanyByDocumentUseCase {

    private CompanyRepositoryPort companyRepositoryPort;

    public Optional<Company> findByDocument(String document) {
        var doc = Long.parseLong(document);

        var company = companyRepositoryPort.findByDocument(doc);

        return company;

    }
}
