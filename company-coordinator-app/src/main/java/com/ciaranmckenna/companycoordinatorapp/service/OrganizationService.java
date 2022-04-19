package com.ciaranmckenna.companycoordinatorapp.service;

import com.ciaranmckenna.companycoordinatorapp.model.Application;
import com.ciaranmckenna.companycoordinatorapp.model.Organization;
import com.ciaranmckenna.companycoordinatorapp.repository.ApplicationRepository;
import com.ciaranmckenna.companycoordinatorapp.repository.OrganizationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final ApplicationRepository applicationRepository;

    public OrganizationService(final OrganizationRepository organizationRepository, final ApplicationRepository applicationRepository) {
        this.organizationRepository = organizationRepository;
        this.applicationRepository = applicationRepository;
    }


    public List<Organization> getAllOrganizations(){
        return organizationRepository.findAll();
    }

    public Organization getOrganizationById(final Long id){
        return organizationRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Set<Application> getAllApplicationsWithOrganizationId(final Long id){
        return organizationRepository.findById(id).get().getApplications();
    }

    public Set<Application> getAllApplicationsWithOrganizationIdStartingWithLetter(Long id, final String letter){
        return applicationRepository.findByOrgIdAndApplicationNameLike(id, letter);
    }

    public Organization findByOrganizationName(final String letter){
        return organizationRepository.findByOrganizationNameLike(letter);
    }

    // findByOrgIdAndApplicationNameLike
}
