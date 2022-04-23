package com.ciaranmckenna.companycoordinatorapp.service;

import com.ciaranmckenna.companycoordinatorapp.model.Application;
import com.ciaranmckenna.companycoordinatorapp.model.Organization;
import com.ciaranmckenna.companycoordinatorapp.repository.ApplicationRepository;
import com.ciaranmckenna.companycoordinatorapp.repository.OrganizationRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final ApplicationRepository applicationRepository;

    public OrganizationService(final OrganizationRepository organizationRepository, final ApplicationRepository applicationRepository) {
        this.organizationRepository = organizationRepository;
        this.applicationRepository = applicationRepository;
    }


    public List<Organization> getAllOrganizations(){

        try {
            return organizationRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException(String.valueOf(HttpStatus.NOT_FOUND));
        }
    }

    /*public Organization getOrganizationById(final Long id) throws ResourceNotFoundException{
        return organizationRepository.findById(id).orElseThrow((ResourceNotFoundException::new));
    }*/

    public Organization getOrganizationById(final Long id) {
        try {
            return organizationRepository.findById(id).get();
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            throw new ResourceNotFoundException(String.valueOf(HttpStatus.NOT_FOUND));
        }
    }

    public List<Application> getAllApplicationsWithOrganizationId(final Long id){
        return organizationRepository.findById(id).map(Organization::getApplications).orElseThrow(ResourceNotFoundException::new);
    }

    public List<Application> getAllApplicationsWithOrganizationIdStartingWithLetterOrder(final Long id, final String letter, Pageable pageable) throws ResourceNotFoundException{
        // NOT THROWING THE EXCEPTION AS EXPECTED
        try {
            return applicationRepository.findByOrgIdAndApplicationNameLikeOrder(id, letter, pageable);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            throw new ResourceNotFoundException(String.valueOf(HttpStatus.NOT_FOUND));
        }
    }

    public Organization findByOrganizationName(final String letter){
        return organizationRepository.findByOrganizationNameLike(letter);
    }

}
