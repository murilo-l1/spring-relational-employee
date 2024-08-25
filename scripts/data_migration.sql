USE employee_tracker;

-- create a new table for address
USE employee_tracker;

CREATE TABLE employee_address (
    address_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    employee_id BIGINT UNIQUE,  -- Ensure one-to-one relationship
    address VARCHAR(255) NOT NULL,
    address_number INT NOT NULL,
    CONSTRAINT fk_employee
        FOREIGN KEY (employee_id) REFERENCES employees(id)
        ON DELETE CASCADE  -- Cascade delete
);

-- Migrate the data to employee_address table
INSERT INTO employee_address (employee_id, address, address_number)
SELECT id, address, address_number
FROM employees;

-- Verify the data migration
SELECT * FROM employee_address;

-- Drop the columns from employees table
ALTER TABLE employees
DROP COLUMN address,
DROP COLUMN address_number;

-- 4. Verify the changes in employees table
DESCRIBE employees;