package com.estudo.cleanarch.core.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Cnpj {

    private String number;

    public Long getCnpjToId() {
        return Long.valueOf(this.number);
    }
}
