INSERT INTO organizations (name, description) VALUES ('HR','HR Organisation');
INSERT INTO organizations (name, description) VALUES ('Accounting','Accounting Organisation');
INSERT INTO organizations (name, description) VALUES ('IT','IT Organisation');

INSERT INTO platforms (name, description) VALUES ('AWS', 'AWS Cloud Platform');
INSERT INTO platforms (name, description) VALUES ('PCF', 'Pivotal Cloud Foundry Platform');
INSERT INTO platforms (name, description) VALUES ('AZURE', 'Azure Cloud Platform');

INSERT INTO applications (name, description, platform_id) VALUES ('HR Helper', 'HR application', '1');
INSERT INTO applications (name, description, platform_id) VALUES ('Catalog', 'Catalog application', '3');
INSERT INTO applications (name, description, platform_id) VALUES ('Sage', 'Accounting Application', '2');
INSERT INTO applications (name, description, platform_id) VALUES ('Change Mgmt', 'Change Application', '3');
INSERT INTO applications (name, description, platform_id) VALUES ('Release Mgmt', 'Release Application', '3');

INSERT INTO organization_application_lookup (organization_id, application_id) VALUES ('1', '1');
INSERT INTO organization_application_lookup (organization_id, application_id) VALUES ('1', '2');
INSERT INTO organization_application_lookup (organization_id, application_id) VALUES ('2', '2');
INSERT INTO organization_application_lookup (organization_id, application_id) VALUES ('2', '3');
INSERT INTO organization_application_lookup (organization_id, application_id) VALUES ('3', '2');
INSERT INTO organization_application_lookup (organization_id, application_id) VALUES ('3', '4');
INSERT INTO organization_application_lookup (organization_id, application_id) VALUES ('3', '5');





