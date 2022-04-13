package com.ciaranmckenna.companycoordinatorapp.repository;

import com.ciaranmckenna.companycoordinatorapp.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
