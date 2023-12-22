package com.estudo.cleanarch.core.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
//read only class
public class Company {

    private final Cnpj cnpj;
    private final String name;
    private final FundationDate fundationDate;
    private final List<Address> addresses;
}
