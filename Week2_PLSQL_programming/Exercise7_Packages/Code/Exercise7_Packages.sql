-- Enable output
SET SERVEROUTPUT ON;

-- =============================================
-- PACKAGE 1: CustomerManagement
-- =============================================

-- Specification
CREATE OR REPLACE PACKAGE CustomerManagement IS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2);
    FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

-- Body
CREATE OR REPLACE PACKAGE BODY CustomerManagement IS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_name);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error adding customer: ' || SQLERRM);
    END;

    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2) IS
    BEGIN
        UPDATE Customers SET Name = p_name WHERE CustomerID = p_id;
        DBMS_OUTPUT.PUT_LINE('Customer updated: ' || p_id);
    END;

    FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_id;
        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END;
END CustomerManagement;
/

-- =============================================
-- PACKAGE 2: EmployeeManagement
-- =============================================

-- Specification
CREATE OR REPLACE PACKAGE EmployeeManagement IS
    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_pos VARCHAR2, p_salary NUMBER, p_dept VARCHAR2, p_date DATE);
    PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER);
    FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

-- Body
CREATE OR REPLACE PACKAGE BODY EmployeeManagement IS
    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_pos VARCHAR2, p_salary NUMBER, p_dept VARCHAR2, p_date DATE) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_id, p_name, p_pos, p_salary, p_dept, p_date);
        DBMS_OUTPUT.PUT_LINE('Employee hired: ' || p_name);
    END;

    PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER) IS
    BEGIN
        UPDATE Employees SET Salary = p_salary WHERE EmployeeID = p_id;
        DBMS_OUTPUT.PUT_LINE('Employee salary updated: ' || p_id);
    END;

    FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_id;
        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END;
END EmployeeManagement;
/

-- =============================================
-- PACKAGE 3: AccountOperations
-- =============================================

-- Specification
CREATE OR REPLACE PACKAGE AccountOperations IS
    PROCEDURE OpenAccount(p_id NUMBER, p_customer_id NUMBER, p_type VARCHAR2, p_balance NUMBER);
    PROCEDURE CloseAccount(p_id NUMBER);
    FUNCTION GetTotalBalance(p_customer_id NUMBER) RETURN NUMBER;
END AccountOperations;
/

-- Body
CREATE OR REPLACE PACKAGE BODY AccountOperations IS
    PROCEDURE OpenAccount(p_id NUMBER, p_customer_id NUMBER, p_type VARCHAR2, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_id, p_customer_id, p_type, p_balance, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Account opened: ' || p_id);
    END;

    PROCEDURE CloseAccount(p_id NUMBER) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_id;
        DBMS_OUTPUT.PUT_LINE('Account closed: ' || p_id);
    END;

    FUNCTION GetTotalBalance(p_customer_id NUMBER) RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        SELECT NVL(SUM(Balance), 0) INTO v_total
        FROM Accounts WHERE CustomerID = p_customer_id;
        RETURN v_total;
    END;
END AccountOperations;
/

-- =============================================
-- TESTING ALL PACKAGES
-- =============================================
BEGIN
    -- CustomerManagement
    CustomerManagement.AddCustomer(3, 'New Customer', TO_DATE('1970-01-01', 'YYYY-MM-DD'), 2000);
    CustomerManagement.UpdateCustomer(3, 'New Name');
    DBMS_OUTPUT.PUT_LINE('Customer 3 balance: ' || CustomerManagement.GetBalance(3));

    -- EmployeeManagement
    EmployeeManagement.HireEmployee(3, 'Charlie Green', 'Analyst', 45000, 'Finance', SYSDATE);
    EmployeeManagement.UpdateEmployee(3, 47000);
    DBMS_OUTPUT.PUT_LINE('Annual salary: ' || EmployeeManagement.GetAnnualSalary(3));

    -- AccountOperations
    AccountOperations.OpenAccount(3, 3, 'Savings', 5000);
    DBMS_OUTPUT.PUT_LINE('Total balance of customer 3: ' || AccountOperations.GetTotalBalance(3));
    AccountOperations.CloseAccount(3);
END;
/
