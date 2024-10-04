CREATE TABLE review (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    rating DOUBLE,
    company_id BIGINT,
    FOREIGN KEY (company_id) REFERENCES company(id)
);
