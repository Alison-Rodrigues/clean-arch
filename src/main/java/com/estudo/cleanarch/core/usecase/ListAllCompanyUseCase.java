package com.estudo.cleanarch.core.usecase;

import com.estudo.cleanarch.core.domain.Company;
import com.estudo.cleanarch.core.ports.CompanyRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ListAllCompanyUseCase {

    private CompanyRepositoryPort companyRepositoryPort;

    public List<Company> findAll() {

        var allCompanies = companyRepositoryPort.listAll();

        return allCompanies;
    }
}
