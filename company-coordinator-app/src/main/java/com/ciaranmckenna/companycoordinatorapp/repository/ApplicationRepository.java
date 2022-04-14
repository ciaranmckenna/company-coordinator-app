package com.ciaranmckenna.companycoordinatorapp.repository;

import com.ciaranmckenna.companycoordinatorapp.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
