package com.estudo.cleanarch.adapter.database.repository;

import com.estudo.cleanarch.adapter.database.entity.CompanyEntity;
import com.estudo.cleanarch.adapter.database.mapper.EntityDomainMapper;
import com.estudo.cleanarch.core.domain.Company;
import com.estudo.cleanarch.core.exceptions.NotFoundException;
import com.estudo.cleanarch.core.ports.CompanyRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//essa camada de adapter implementa o CompanyRepositoryPort definido no core
//sempre a camada externa implementa a camada mais interna e nunca ao contrário
@Component
@RequiredArgsConstructor
class CompanyRepositoryPortImpl implements CompanyRepositoryPort {

    private final CompanyRepository companyRepository;
    private final EntityDomainMapper mapper;

    @Override
    public Optional<Company> saveOrUpdate(Company company) {
        var entity = mapper.toEntity(company);

        var save = companyRepository.save(entity);

        return Optional.of(mapper.toDomain(save));
    }

    @Override
    public Optional<Company> findByDocument(long document) {
        var company = companyRepository.findById(document);

        return Optional.of(mapper.toDomain(company.orElseThrow(NotFoundException::new)));
    }

    @Override
    public List<Company> listAll() {
        var companies = companyRepository.findAll();

        return (List<Company>) mapper.toDomain((CompanyEntity) companies);
    }

    @Override
    public void delete(long document) {
        companyRepository.delete(
                CompanyEntity
                        .builder()
                        .cnpj(document)
                        .build()
        );
    }
}
