package com.ciaranmckenna.companycoordinatorapp.repository;

import com.ciaranmckenna.companycoordinatorapp.model.Application;
import com.ciaranmckenna.companycoordinatorapp.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {


    /*@Query("SELECT a FROM Application a WHERE LOWER (a.name) LIKE LOWER(CONCAT('%', ?1,'%'))")
    Set<Application> findByOrganizationNameLikeCaseInsensitive(String name);*/

    /*Set<Application> findByOrganizationNameOrderByLevelAsc(String name);
    @Query("SELECT o FROM Tutorial t WHERE t.published=true ORDER BY t.createdAt DESC")*/

    /*@Query("SELECT o FROM Organization o WHERE (o.applications) = :id")
    Set<Application> findByOrgIdAndApplicationNameLike(@Param("name") String name);*/


}
