package com.estudo.cleanarch.core.ports;

import com.estudo.cleanarch.core.domain.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepositoryPort {

    public Optional<Company> saveOrUpdate(Company company);
    public Optional<Company> findByDocument(long document);
    public List<Company> listAll();
    public void delete(long document);
}
