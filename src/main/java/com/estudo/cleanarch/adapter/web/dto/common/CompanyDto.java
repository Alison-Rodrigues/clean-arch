package com.estudo.cleanarch.adapter.web.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Pattern;

@SuperBuilder
@Getter
public class CompanyDto {


    private final String cnpj;

    @JsonProperty("name_company")
    private final String name;

    @JsonProperty("fundation_date")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "O campo de data deve seguir o padrão yyyy-mm-dd")
    private final String fundationDate;

}
