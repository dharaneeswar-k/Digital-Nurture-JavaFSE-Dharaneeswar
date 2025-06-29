SET SERVEROUTPUT ON;


CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR acct IN (SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'Savings') LOOP
        UPDATE Accounts
        SET Balance = Balance + (acct.Balance * 0.01),
            LastModified = SYSDATE
        WHERE AccountID = acct.AccountID;

        DBMS_OUTPUT.PUT_LINE('1% interest applied to AccountID: ' || acct.AccountID);
    END LOOP;

    COMMIT;
END;
/


CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_pct  IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_pct / 100)
    WHERE Department = p_department;

    IF SQL%ROWCOUNT = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No employees found in department ' || p_department);
    ELSE
        DBMS_OUTPUT.PUT_LINE('Bonus applied to ' || SQL%ROWCOUNT || ' employee(s) in ' || p_department || ' department.');
    END IF;

    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
) IS
    v_balance NUMBER;
BEGIN
    -- Get source account balance
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;

    -- Perform fund transfer
    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_from_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_to_account;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Transferred ' || p_amount || ' from Account ' || p_from_account || ' to Account ' || p_to_account);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error during transfer: ' || SQLERRM);
END;
/
BEGIN
    -- Scenario 1: Apply monthly interest
    ProcessMonthlyInterest;

    -- Scenario 2: Apply 20% bonus to IT department
    UpdateEmployeeBonus('IT', 20);

    -- Scenario 3: Transfer 200 from Account 1 to Account 2
    TransferFunds(1, 2, 200);
END;
/
