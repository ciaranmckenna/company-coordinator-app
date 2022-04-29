package com.ciaranmckenna.companycoordinatorapp;

import com.ciaranmckenna.companycoordinatorapp.model.Organization;
import com.ciaranmckenna.companycoordinatorapp.repository.OrganizationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAUnitTest {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Test
    void shouldFindOrganizationsIfRepositoryIsNotEmpty() {
        Iterable<Organization> organizations = organizationRepository.findAll();
        assertThat(organizations).isNotEmpty();
    }

}
