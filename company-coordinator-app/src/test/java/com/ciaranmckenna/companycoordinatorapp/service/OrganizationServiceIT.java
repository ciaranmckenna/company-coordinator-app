package com.ciaranmckenna.companycoordinatorapp.service;

import com.ciaranmckenna.companycoordinatorapp.model.Organization;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class OrganizationServiceIT {

    private static final Long ORGANIZATION_ID = 1L;
    private static final String ORGANIZATION_NAME = "Company One";
    private static final String ORGANIZATION_DESCRIPTION = "Customer Solutions";

    private OrganizationService organizationService;

    OrganizationServiceIT(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }


    @Test
    void getOrganizationById() {
        // given
        Organization organizationMock = new Organization(ORGANIZATION_NAME, ORGANIZATION_DESCRIPTION);

        // when
        organizationService.getOrganizationById(organizationMock.getId());

        // then
        assertEquals(1L, organizationMock.getId());

    }

    @Test
    void getAllApplicationsWithOrganizationId() {
    }

    @Test
    void getAllApplicationsWithOrganizationIdStartingWithLetterOrder() {
    }

    @Test
    void findByOrganizationName() {
    }
}