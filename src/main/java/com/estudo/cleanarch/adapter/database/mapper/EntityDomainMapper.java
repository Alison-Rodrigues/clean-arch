package com.estudo.cleanarch.adapter.database.mapper;

import com.estudo.cleanarch.adapter.database.entity.CompanyEntity;
import com.estudo.cleanarch.core.domain.Cnpj;
import com.estudo.cleanarch.core.domain.Company;
import com.estudo.cleanarch.core.domain.FundationDate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntityDomainMapper {

    //domain para entity
    public CompanyEntity toEntity(Company company) {
        return CompanyEntity
                .builder()
                .cnpj(company.getCnpj().getCnpjToId())
                .name(company.getName())
                .fundationDate(company.getFundationDate().getDate())
                .build();
    }

    //entity para domain
    public Company toDomain(CompanyEntity entity) {
        return Company
                .builder()
                .cnpj(Cnpj
                        .builder()
                        .number(String.valueOf(entity.getCnpj()))
                        .build())
                .name(entity.getName())
                .fundationDate(FundationDate
                        .builder()
                        .date(entity.getFundationDate())
                        .build())
                .build();
    }



}
