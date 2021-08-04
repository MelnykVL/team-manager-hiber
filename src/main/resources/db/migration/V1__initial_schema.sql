CREATE TABLE skills (
    skill_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TYPE status AS ENUM ('ACTIVE', 'DELETED');
CREATE TABLE teams (
    team_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    team_status status NOT NULL DEFAULT 'ACTIVE'
);

CREATE TABLE developers (
    developer_id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    team_id INT,
    FOREIGN KEY(team_id) REFERENCES teams(team_id)
);

CREATE TABLE developers_skills (
    developer_id INT,
    skill_id INT,
    PRIMARY KEY (developer_id, skill_id),
    CONSTRAINT fk_developer FOREIGN KEY (developer_id) REFERENCES developers(developer_id),
    CONSTRAINT fk_skill FOREIGN KEY (skill_id) REFERENCES skills(skill_id)
);