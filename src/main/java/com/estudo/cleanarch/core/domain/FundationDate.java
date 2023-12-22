package com.estudo.cleanarch.core.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Builder
@Getter
public class FundationDate {

    private LocalDate date;

    public boolean isValidDate() {
        return !this.date.isAfter(LocalDate.now());
    }

    public String getFormattedDateS() {
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
