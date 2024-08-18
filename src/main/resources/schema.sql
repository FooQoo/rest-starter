DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS company_position;

CREATE TABLE company_position
(
    company_position_id INT AUTO_INCREMENT PRIMARY KEY,
    name                VARCHAR(32) NOT NULL
);

CREATE TABLE member
(
    member_id           INT AUTO_INCREMENT PRIMARY KEY,
    name                VARCHAR(255) NOT NULL,
    company_position_id INT,
    FOREIGN KEY (company_position_id) REFERENCES company_position (company_position_id)
);





