-- Enable DBMS_OUTPUT
SET SERVEROUTPUT ON;

-- ============================================
-- TABLE: AuditLog for transaction auditing
-- ============================================
CREATE TABLE AuditLog (
    AuditID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    TransactionID NUMBER,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    LogTime DATE
);

-- ============================================
-- TRIGGER 1: UpdateCustomerLastModified
-- Automatically update LastModified when a customer is updated
-- ============================================
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/

-- ============================================
-- TRIGGER 2: LogTransaction
-- Insert audit log record after a transaction is added
-- ============================================
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (
        TransactionID,
        AccountID,
        TransactionDate,
        Amount,
        TransactionType,
        LogTime
    )
    VALUES (
        :NEW.TransactionID,
        :NEW.AccountID,
        :NEW.TransactionDate,
        :NEW.Amount,
        :NEW.TransactionType,
        SYSDATE
    );
END;
/

-- ============================================
-- TRIGGER 3: CheckTransactionRules
-- Validate transaction rules before insert
-- ============================================
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    -- Fetch current account balance
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = :NEW.AccountID;

    -- Rule 1: Withdrawal should not exceed balance
    IF :NEW.TransactionType = 'Withdrawal' AND :NEW.Amount > v_balance THEN
        RAISE_APPLICATION_ERROR(-20001, 'Withdrawal amount exceeds account balance.');
    END IF;

    -- Rule 2: Deposit must be positive
    IF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
    END IF;
END;
/

-- ============================================
-- TESTING TRIGGERS
-- ============================================
-- 1. Update a customer and see LastModified update
UPDATE Customers
SET Name = 'John Doe Updated'
WHERE CustomerID = 1;

-- 2. Valid transaction (Deposit)
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (10, 1, SYSDATE, 500, 'Deposit');

-- 3. Invalid transaction: Withdrawal more than balance
-- Will raise error ORA-20001
-- Uncomment below to test
-- INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
-- VALUES (11, 1, SYSDATE, 100000, 'Withdrawal');

-- 4. Invalid transaction: Negative deposit
-- Will raise error ORA-20002
-- Uncomment below to test
-- INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
-- VALUES (12, 1, SYSDATE, -100, 'Deposit');

-- 5. View audit log entries
BEGIN
    FOR rec IN (SELECT * FROM AuditLog ORDER BY LogTime DESC) LOOP
        DBMS_OUTPUT.PUT_LINE('AuditLog: TxnID=' || rec.TransactionID || ', Type=' || rec.TransactionType || ', Amount=' || rec.Amount);
    END LOOP;
END;
/
UPDATE Customers SET Name = 'John Doe Updated' WHERE CustomerID = 1;
SELECT LastModified FROM Customers WHERE CustomerID = 1;

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (10, 1, SYSDATE, 500, 'Deposit');
SELECT * FROM AuditLog WHERE TransactionID = 10;
