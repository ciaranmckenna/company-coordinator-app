package com.ciaranmckenna.companycoordinatorapp.repository;

import com.ciaranmckenna.companycoordinatorapp.model.Application;
import com.ciaranmckenna.companycoordinatorapp.model.Organization;
import com.ciaranmckenna.companycoordinatorapp.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {


    /*@Query("SELECT a FROM Application a" +
            "    LEFT JOIN OrgAppMapper oalu ON ( a.id = oalu.applicationId)" +
            "    where oalu.organisationId = :org_id AND a.name LIKE %:name")
    Set<Application> findByOrgIdAndApplicationNameLike(@Param("org_id") Long org_id, @Param("name") String name);*/

    /*SELECT a FROM Application a
    LEFT JOIN organization_application_lookup oalu ON ( a.id = oalu.application_id)
    where oalu.organization_id = :org_id*/





    // /organizations/3/applications?query=C

    /*@Query("FROM Application WHERE name=?1 order by name")
    Set<Application> findByOrgIdAndApplicationNameLike(Long id, String name);*/


   /* @Query("SELECT * FROM Application")
    Set<Application> findByOrganizationNameLikeCaseInsensitive(Character name);*/

    @Query("FROM Application WHERE name =?1")
    Set<Application> findByOrgIdAndApplicationNameLike(Long id, String name);

    //@Query(value = "SELECT * FROM applications WHERE name LIKE 'c%'", nativeQuery = true)

    //Set<Application> findByOrganizationNameContaining(String name, Sort sort);

}
