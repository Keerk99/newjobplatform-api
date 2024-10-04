CREATE TABLE job (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    min_salary VARCHAR(255),
    max_salary VARCHAR(255),
    location VARCHAR(255),
    company_id BIGINT,
    FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE CASCADE
);
