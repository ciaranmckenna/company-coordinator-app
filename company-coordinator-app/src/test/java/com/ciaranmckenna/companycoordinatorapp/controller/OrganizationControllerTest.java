package com.ciaranmckenna.companycoordinatorapp.controller;

import com.ciaranmckenna.companycoordinatorapp.model.Application;
import com.ciaranmckenna.companycoordinatorapp.model.Organization;
import com.ciaranmckenna.companycoordinatorapp.service.OrganizationService;
import com.ciaranmckenna.companycoordinatorapp.service.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrganizationController.class)
class OrganizationControllerTest {

    @MockBean
    private OrganizationService organizationService;

    @Autowired
    private MockMvc mockMvc;

    private static final Long ORGANIZATION_ID = 1L;
    private static final String ORGANIZATION_NAME = "Company One";
    private static final String ORGANIZATION_DESCRIPTION = "Customer Organization Solutions";

    private static final Long APPLICATION_ID = 1L;
    private static final String APPLICATION_NAME = "Application One";
    private static final String APPLICATION_DESCRIPTION = "Customer Application Solutions";

    private final Organization organization = new Organization(ORGANIZATION_ID, ORGANIZATION_NAME, ORGANIZATION_DESCRIPTION);

    private final Application application = new Application(APPLICATION_ID, APPLICATION_NAME, APPLICATION_DESCRIPTION);

    @Test
    void getAllOrganizations() throws Exception {
        List<Organization> organizationList = List.of(organization);

        given(organizationService.getAllOrganizations()).willReturn(organizationList);
        mockMvc.perform(get("/organizations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(organizationList.size()))
        .andDo(print());
    }

// TODO sort out the passing of json object to the api call
   /* @Test
    void getOrganizationByName() throws Exception {
        // when

        when(organizationService.findByOrganizationName(ORGANIZATION_NAME)).thenReturn(organization);
        mockMvc.perform(get("/organizations/name", ORGANIZATION_NAME)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value(organization.getDescription()))
                ;
    }*/

    @Test
    void getOrganizationByID() throws Exception {

        // when
        when(organizationService.getOrganizationById(ORGANIZATION_ID)).thenReturn(organization);
        mockMvc.perform(get("/organizations/{id}", ORGANIZATION_ID)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ORGANIZATION_ID))
                .andExpect(jsonPath("$.name").value(organization.getName()))
                .andExpect(jsonPath("$.description").value(organization.getDescription()))
                .andDo(print());
    }

    @Test
    void getAllApplicationsWithOrganizationId() throws Exception {
        // when

        List<Application> applicationList = List.of(application);
        when(organizationService.getAllApplicationsWithOrganizationId(ORGANIZATION_ID)).thenReturn(applicationList);
        mockMvc.perform(get("/organizations/{id}/applications", ORGANIZATION_ID)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ORGANIZATION_ID))
                .andExpect(jsonPath("$.name").value(application.getName()))
                .andExpect(jsonPath("$.description").value(application.getDescription()))
                .andDo(print());
    }

    /*public List<Application> getAllApplicationsWithOrganizationId(final Long id){
        return organizationRepository.findById(id).map(Organization::getApplications).orElseThrow(ResourceNotFoundException::new);
    }*/
}