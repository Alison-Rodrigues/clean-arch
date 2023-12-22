package com.estudo.cleanarch.config.spring;

import com.estudo.cleanarch.core.ports.CompanyRepositoryPort;
import com.estudo.cleanarch.core.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanConfig {

    @Bean
    CreateCompanyUseCase createCompanyUseCase(CompanyRepositoryPort companyRepositoryPort) {
        return new CreateCompanyUseCase(companyRepositoryPort);
    }

    @Bean
    DeleteCompanyUseCase deleteCompanyUseCase(CompanyRepositoryPort companyRepositoryPort) {
        return new DeleteCompanyUseCase(companyRepositoryPort);
    }

    @Bean
    FindCompanyByDocumentUseCase findCompanyByDocumentUseCase(CompanyRepositoryPort companyRepositoryPort) {
        return new FindCompanyByDocumentUseCase(companyRepositoryPort);
    }

    @Bean
    ListAllCompanyUseCase listAllCompanyUseCase(CompanyRepositoryPort companyRepositoryPort) {
        return new ListAllCompanyUseCase(companyRepositoryPort);
    }

    @Bean
    UpdateCompanyUseCase updateCompanyUseCase(CompanyRepositoryPort companyRepositoryPort) {
        return new UpdateCompanyUseCase(companyRepositoryPort);
    }

}
