package com.ciaranmckenna.companycoordinatorapp.repository;

import com.ciaranmckenna.companycoordinatorapp.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {


    // find organization by the organization name that has been passed in
    @Query("FROM Organization WHERE name =?1")
    Organization findByOrganizationNameLike(@Param("name") String name);

}
