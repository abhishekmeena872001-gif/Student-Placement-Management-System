CREATE DATABASE IF NOT EXISTS placement_db;
USE placement_db;

CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    branch VARCHAR(50) NOT NULL,
    percentage DECIMAL(5,2) NOT NULL,
    placed BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS companies (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    minimum_percentage DECIMAL(5,2) NOT NULL,
    role VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS applications (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    company_id INT NOT NULL,
    status VARCHAR(30) DEFAULT 'Applied',
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (company_id) REFERENCES companies(id)
);

INSERT INTO students (id, name, branch, percentage, placed) VALUES
(101, 'Aarav Sharma', 'CSE', 82.50, FALSE),
(102, 'Priya Verma', 'AIML', 88.00, FALSE),
(103, 'Rohit Singh', 'IT', 74.50, FALSE)
ON DUPLICATE KEY UPDATE name=VALUES(name);

INSERT INTO companies (id, name, minimum_percentage, role) VALUES
(1, 'TechNova', 75.00, 'Java Developer'),
(2, 'DataWorks', 80.00, 'Software Engineer')
ON DUPLICATE KEY UPDATE name=VALUES(name);
