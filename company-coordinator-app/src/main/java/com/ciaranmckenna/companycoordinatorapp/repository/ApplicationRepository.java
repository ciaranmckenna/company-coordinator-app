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

    /*@Query("FROM Application WHERE name =?1")
    Set<Application> findByOrgIdAndApplicationNameLike(Long id, String name);*/

    @Query("SELECT a FROM Application a" +
            "    LEFT JOIN OrgAppMapper oalu ON ( a.id = oalu.applicationId)" +
            "    where oalu.organizationId = :org_id AND a.name LIKE %:name")
    Set<Application> findByOrgIdAndApplicationNameLike(@Param("org_id") Long org_id, @Param("name") String name);

    /*@Query("FROM Application WHERE name=?1 order by name")
    Set<Application> findByOrgIdAndApplicationNameLike(Long id, String name);*/


   /* @Query("SELECT * FROM Application")
    Set<Application> findByOrganizationNameLikeCaseInsensitive(Character name);*/

    //@Query(value = "SELECT * FROM applications WHERE name LIKE 'c%'", nativeQuery = true)

    //Set<Application> findByOrganizationNameContaining(String name, Sort sort);

}
