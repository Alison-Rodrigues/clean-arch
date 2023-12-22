package com.estudo.cleanarch.adapter.database.repository;

import com.estudo.cleanarch.adapter.database.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
}
