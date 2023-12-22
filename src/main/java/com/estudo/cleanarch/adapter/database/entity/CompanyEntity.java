package com.estudo.cleanarch.adapter.database.entity;

import com.estudo.cleanarch.core.domain.Address;
import com.estudo.cleanarch.core.domain.Cnpj;
import com.estudo.cleanarch.core.domain.FundationDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
public class CompanyEntity {

    @Id
    private Long cnpj;

    @Setter
    private String name;

    @Setter
    private LocalDate fundationDate;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastUpdate;
}
