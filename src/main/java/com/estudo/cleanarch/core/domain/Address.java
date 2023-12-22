package com.estudo.cleanarch.core.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Address {

    private final String address;
    private final String number;
    private final String postal_code;
    private final String neighborhood;
    private final String country;

}
