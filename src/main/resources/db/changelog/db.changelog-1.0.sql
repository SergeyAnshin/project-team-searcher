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

--changeset SergeyAnshin:add-foreign_key-project_technology-project
ALTER TABLE project_technology
ADD CONSTRAINT fk_project_technology_project_id
FOREIGN KEY (project_id) REFERENCES project (project_id);

--changeset SergeyAnshin:add-foreign_key-project_technology-technology
ALTER TABLE project_technology
ADD CONSTRAINT fk_project_technology_technology_id
FOREIGN KEY (technology_id) REFERENCES technology (technology_id);
