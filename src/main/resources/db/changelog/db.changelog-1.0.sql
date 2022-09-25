--liquibase formatted sql

--changeset SergeyAnshin:create-project-table
CREATE TABLE project (
    project_id INT AUTO_INCREMENT,
    name varchar(40) NOT NULL,
    description varchar(255),
    link varchar(100) NOT NULL UNIQUE,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_project_id PRIMARY KEY (project_id)
);

--changeset SergeyAnshin:create-position-table
CREATE TABLE position (
    position_id INT AUTO_INCREMENT,
    name varchar(40) NOT NULL UNIQUE,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_position_id PRIMARY KEY (position_id)
);
--rollback position

--changeset SergeyAnshin:create-technology-table
CREATE TABLE technology (
    technology_id INT AUTO_INCREMENT,
    name varchar(40) NOT NULL UNIQUE,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_technology_id PRIMARY KEY (technology_id)
);

--changeset SergeyAnshin:create-project-technology-table
CREATE TABLE project_technology (
    project_id INT NOT NULL,
    technology_id INT NOT NULL,
    CONSTRAINT uk_project_technology UNIQUE (project_id, technology_id)
);

--changeset SergeyAnshin:add-foreign-key-project_technology-project
ALTER TABLE project_technology
ADD CONSTRAINT fk_project_technology_project_id
FOREIGN KEY (project_id) REFERENCES project (project_id);

--changeset SergeyAnshin:add-foreign-key-project-technology-technology
ALTER TABLE project_technology
ADD CONSTRAINT fk_project_technology_technology_id
FOREIGN KEY (technology_id) REFERENCES technology (technology_id);

--changeset SergeyAnshin:create-team-member-table
CREATE TABLE team_member (
    team_member_id INT AUTO_INCREMENT,
    position_id INT NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_team_member_id PRIMARY KEY (team_member_id)
);

--changeset SergeyAnshin:add-foreign-key-team-member-position
ALTER TABLE team_member
ADD CONSTRAINT fk_team_member_position_id
FOREIGN KEY (position_id) REFERENCES position (position_id);

--changeset SergeyAnshin:create-project-team-member-table
CREATE TABLE project_team_member (
    project_id INT NOT NULL,
    team_member_id INT NOT NULL,
    CONSTRAINT uk_project_team_member UNIQUE (project_id,team_member_id)
);

--changeset SergeyAnshin:add-foreign-key-project-team-member-project
ALTER TABLE project_team_member
ADD CONSTRAINT fk_project_team_member_project_id
FOREIGN KEY (project_id) REFERENCES project (project_id);

--changeset SergeyAnshin:add-foreign-key-project-team-member-team-member
ALTER TABLE project_team_member
ADD CONSTRAINT fk_project_team_member_team_member_id
FOREIGN KEY (team_member_id) REFERENCES team_member (team_member_id);
