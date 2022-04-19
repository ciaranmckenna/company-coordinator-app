package com.ciaranmckenna.companycoordinatorapp.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "organization_application_lookup")
public class OrgAppMapper {

    @EmbeddedId
    @Column(name = "organization_id")
    private Long organizationId;
    @Column(name = "application_id")
    private Long applicationId;

    public OrgAppMapper() {
    }

    public OrgAppMapper(Long organizationId, Long applicationId) {
        this.organizationId = organizationId;
        this.applicationId = applicationId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organisationId) {
        this.organizationId = organisationId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

}
