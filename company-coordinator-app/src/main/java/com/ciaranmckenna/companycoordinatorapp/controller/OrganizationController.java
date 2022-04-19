package com.ciaranmckenna.companycoordinatorapp.controller;

import com.ciaranmckenna.companycoordinatorapp.model.Application;
import com.ciaranmckenna.companycoordinatorapp.model.Organization;
import com.ciaranmckenna.companycoordinatorapp.service.OrganizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(final OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public ResponseEntity<List<Organization>> getAllOrganizations(){
        return ResponseEntity.ok(organizationService.getAllOrganizations());
    }

    @GetMapping("/name")
    public ResponseEntity<Organization> getOrganizationByName(String name){
        return ResponseEntity.ok(organizationService.findByOrganizationName(name));
    }

    // return ResponseEntity.ok(organizationService.getAllOrganizationStartingWithName(name));

    @GetMapping("/{id}")
    public ResponseEntity<Organization> getOrganizationByID(@PathVariable("id") final Long id){
        return ResponseEntity.ok(organizationService.getOrganizationById(id));
    }

    @GetMapping("/{id}/applications")
    public ResponseEntity<Set<Application>> getAllApplicationsWithOrganizationId(@PathVariable("id") final Long id, @RequestParam(required = false) String letter){
        if (letter !=null){
            return ResponseEntity.ok(organizationService.getAllApplicationsWithOrganizationIdStartingWithLetter(id, letter));
        }else
        return ResponseEntity.ok(organizationService.getAllApplicationsWithOrganizationId(id));
    }

}
