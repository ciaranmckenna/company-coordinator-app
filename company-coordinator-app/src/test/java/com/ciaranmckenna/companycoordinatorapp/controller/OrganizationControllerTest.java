package com.ciaranmckenna.companycoordinatorapp.controller;

import com.ciaranmckenna.companycoordinatorapp.model.Application;
import com.ciaranmckenna.companycoordinatorapp.model.Organization;
import com.ciaranmckenna.companycoordinatorapp.model.Platform;
import com.ciaranmckenna.companycoordinatorapp.service.OrganizationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
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

    private static final Long PLATFORM_ID = 1L;
    private static final String PLATFORM_NAME = "Platform One";
    private static final String PLATFORM_DESCRIPTION = "Platform One Description";

    private final Organization organization = new Organization(ORGANIZATION_ID, ORGANIZATION_NAME, ORGANIZATION_DESCRIPTION);

    private final Platform platform = new Platform(PLATFORM_ID, PLATFORM_NAME, PLATFORM_DESCRIPTION);

    private final Application application = new Application(APPLICATION_ID, APPLICATION_NAME, APPLICATION_DESCRIPTION, platform);


    @Test
    void getAllOrganizations() throws Exception {
        List<Organization> organizationList = List.of(organization);

        given(organizationService.getAllOrganizations()).willReturn(organizationList);
        mockMvc.perform(get("/organizations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(organizationList.size()))
        .andDo(print());
    }

    @Test
    void shouldReturnNotFoundOrganizations() throws Exception {
        List<Organization> organizationList = List.of(organization);

        given(organizationService.getAllOrganizations()).willReturn(organizationList);
        mockMvc.perform(get("/organizations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(organizationList.size()))
                .andDo(print());
    }

// TODO sort out the passing of json object to the api call
    /*@Test
    void getOrganizationByName() throws Exception {
        // when
        List<Organization> organizations = new ArrayList<>(
        Arrays.asList(new Organization(1L, "Spring Boot @WebMvcTest 1", "Description 1"),
            new Organization(2L, "Spring Boot @WebMvcTest 2", "Description 2"),
            new Organization(3L, "Spring Boot @WebMvcTest 3", "Description 3")));

        String title = "Boot";
        MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
        paramsMap.add("title", title);

        when(organizationService.findByOrganizationName(title)).thenReturn(organizations);
        mockMvc.perform(get("/organizations/name").params(paramsMap))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(organizations.size()))
                .andDo(print());
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

    /*@Test
    void shouldReturnNotFoundOrganizationID() throws Exception {

        // when
        when(organizationService.getOrganizationById(ORGANIZATION_ID)).thenReturn();// want to return a null value as if to say the organization did not exist
        mockMvc.perform(get("/organizations/{id}", ORGANIZATION_ID)).andExpect(status().isNotFound())
                *//*.andExpect(jsonPath("$.id").value(ORGANIZATION_ID))
                .andExpect(jsonPath("$.name").value(organization.getName()))
                .andExpect(jsonPath("$.description").value(organization.getDescription()))*//*
                .andDo(print());
    }*/

    @Test
    void getAllApplicationsWithOrganizationId() throws Exception {
        // when

        List<Application> applicationList = List.of(application);
        when(organizationService.getAllApplicationsWithOrganizationId(ORGANIZATION_ID)).thenReturn(applicationList);
        mockMvc.perform(get("/organizations/{id}/applications", ORGANIZATION_ID)).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(application.getId())) // TODO THIS IS NOT RIGHT SEEMS LIKE A WILD HACK
                .andExpect(jsonPath("$[0].name").value(application.getName()))
                .andExpect(jsonPath("$[0].description").value(application.getDescription()))
                .andDo(print());
    }

}