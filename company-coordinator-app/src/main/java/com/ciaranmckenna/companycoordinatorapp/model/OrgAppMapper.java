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
    private Long organisationId;
    @Column(name = "application_id")
    private Long applicationId;

    public OrgAppMapper() {
    }

    public OrgAppMapper(Long organisationId, Long applicationId) {
        this.organisationId = organisationId;
        this.applicationId = applicationId;
    }

    public Long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(Long organisationId) {
        this.organisationId = organisationId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

}
