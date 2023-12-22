package com.estudo.cleanarch.adapter.web.dto;

import com.estudo.cleanarch.adapter.web.dto.common.CompanyDto;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@SuperBuilder
@Getter
public class CompanyRequest extends CompanyDto {
}
