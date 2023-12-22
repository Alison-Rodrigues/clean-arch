package com.estudo.cleanarch.adapter.web.controllers;

import com.estudo.cleanarch.adapter.web.dto.CompanyRequest;
import com.estudo.cleanarch.adapter.web.dto.common.ResponseDto;
import com.estudo.cleanarch.adapter.web.mapper.RequestResponseMapper;
import com.estudo.cleanarch.core.domain.Company;
import com.estudo.cleanarch.core.usecase.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
@Slf4j
@Validated
public class CompanyController {

    private final RequestResponseMapper mapper;
    private final CreateCompanyUseCase createCompanyUseCase;
    private final DeleteCompanyUseCase deleteCompanyUseCase;
    private final FindCompanyByDocumentUseCase findCompanyByDocumentUseCase;
    private final ListAllCompanyUseCase listAllCompanyUseCase;
    private final UpdateCompanyUseCase updateCompanyUseCase;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/company")
    public ResponseEntity<ResponseDto> saveCompany(@Validated @RequestBody CompanyRequest companyRequest) {

        var domain = createCompanyUseCase.create(mapper.toDomain(companyRequest));

        var response = domain.map(mapper::toResponse).orElseThrow();

        var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(domain.map(Company::getCnpj).orElseThrow())
                .toUri();

        return ResponseEntity.created(location).body(response);

    }

    @PutMapping(path = "/company/{document}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> updateCompany(@PathVariable(value = "document") String document, @Validated @RequestBody CompanyRequest companyRequest) {

        var domain = updateCompanyUseCase.execute(document, mapper.toDomain(companyRequest));

        var response = domain.map(mapper::toResponse).orElseThrow();

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/company/{document}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> findByCnpj(@PathVariable(value = "document") String document) {
        var domain = findCompanyByDocumentUseCase.findByDocument(document);

        var response = domain.map(mapper::toResponse).orElseThrow();

        return ResponseEntity.ok().body(response);
    }





}
