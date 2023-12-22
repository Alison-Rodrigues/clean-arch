package com.estudo.cleanarch.adapter.web.mapper;

import com.estudo.cleanarch.adapter.web.dto.CompanyRequest;
import com.estudo.cleanarch.adapter.web.dto.common.CompanyDto;
import com.estudo.cleanarch.adapter.web.dto.common.ResponseDto;
import com.estudo.cleanarch.core.domain.Cnpj;
import com.estudo.cleanarch.core.domain.Company;
import com.estudo.cleanarch.core.domain.FundationDate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class RequestResponseMapper {

    public Company toDomain(CompanyRequest companyRequest) {
        return Company
                .builder()
                .cnpj(Cnpj
                        .builder()
                        .number(companyRequest.getCnpj())
                        .build())
                .name(companyRequest.getName())
                .fundationDate(
                        FundationDate
                                .builder()
                                .date(LocalDate.parse(companyRequest.getFundationDate(), DateTimeFormatter.ISO_LOCAL_DATE))
                                .build()
                )
                .build();
    }

    private CompanyDto toResponseDto(Company company) {
        return CompanyDto
                .builder()
                .cnpj(company.getCnpj().getNumber())
                .name(company.getName())
                .fundationDate(company.getFundationDate().getFormattedDateS())
                .build();
    }

    public ResponseDto toResponse(Company company) {
        return ResponseDto
                .builder()
                .data(toResponseDto(company))
                .build();
    }


}
