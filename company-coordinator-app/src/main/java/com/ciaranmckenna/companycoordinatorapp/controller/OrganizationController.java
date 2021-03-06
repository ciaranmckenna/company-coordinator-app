package com.ciaranmckenna.companycoordinatorapp.controller;

import com.ciaranmckenna.companycoordinatorapp.model.Application;
import com.ciaranmckenna.companycoordinatorapp.model.Organization;
import com.ciaranmckenna.companycoordinatorapp.service.OrganizationService;
import com.ciaranmckenna.companycoordinatorapp.service.ResourceNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(final OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public ResponseEntity<List<Organization>> getAllOrganizations() {
        return ResponseEntity.ok(organizationService.getAllOrganizations());
    }

    @GetMapping("/name")
    public ResponseEntity<Organization> getOrganizationByName(String name) {
        return ResponseEntity.ok(organizationService.findByOrganizationName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organization> getOrganizationByID(@PathVariable("id") final Long id) {
        return ResponseEntity.ok(organizationService.getOrganizationById(id));
    }

    @GetMapping("/{id}/applications")
    public ResponseEntity<List<Application>> getAllApplicationsWithOrganizationId(
            @PathVariable("id") final Long id,
            @RequestParam(required = false) final String query,
            @PageableDefault() final Pageable pageable) {
        if (query != null){
            final List<Application> applications = organizationService.getAllApplicationsWithOrganizationIdStartingWithLetterOrder(id, query, pageable);
            return ResponseEntity.ok(applications);
        }else
            return ResponseEntity.ok(organizationService.getAllApplicationsWithOrganizationId(id));
    }

}