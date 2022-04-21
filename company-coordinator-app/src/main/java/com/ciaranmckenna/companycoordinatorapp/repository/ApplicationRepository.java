package com.ciaranmckenna.companycoordinatorapp.repository;

import com.ciaranmckenna.companycoordinatorapp.model.Application;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    @Query("SELECT a FROM Application a" +
            "    LEFT JOIN OrgAppMapper oalu ON ( a.id = oalu.applicationId)" +
            "    where oalu.organizationId = :org_id AND a.name LIKE :name%")
    List<Application> findByOrgIdAndApplicationNameLikeOrder(@Param("org_id") Long org_id, @Param("name") String name, Pageable pageable);

}
