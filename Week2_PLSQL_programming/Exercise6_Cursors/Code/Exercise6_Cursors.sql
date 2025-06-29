-- Enable output
SET SERVEROUTPUT ON;

-- ============================================
-- SCENARIO 1: GenerateMonthlyStatements
-- Retrieve current month transactions and print by customer
-- ============================================
DECLARE
    CURSOR txn_cursor IS
        SELECT c.CustomerID, c.Name, t.TransactionDate, t.Amount, t.TransactionType
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE TO_CHAR(t.TransactionDate, 'MM-YYYY') = TO_CHAR(SYSDATE, 'MM-YYYY')
        ORDER BY c.CustomerID, t.TransactionDate;

    v_customer_id Customers.CustomerID%TYPE;
    v_name        Customers.Name%TYPE;
    v_date        DATE;
    v_amount      NUMBER;
    v_type        VARCHAR2(10);
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Monthly Statements ---');
    OPEN txn_cursor;
    LOOP
        FETCH txn_cursor INTO v_customer_id, v_name, v_date, v_amount, v_type;
        EXIT WHEN txn_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Customer: ' || v_name || ' | Date: ' || TO_CHAR(v_date, 'DD-MON') ||
                             ' | Type: ' || v_type || ' | Amount: ' || v_amount);
    END LOOP;
    CLOSE txn_cursor;
END;
/

-- ============================================
-- SCENARIO 2: ApplyAnnualFee
-- Deduct annual fee from all accounts
-- ============================================
DECLARE
    CURSOR acct_cursor IS
        SELECT AccountID, Balance FROM Accounts;

    v_account_id Accounts.AccountID%TYPE;
    v_balance    Accounts.Balance%TYPE;
    v_fee        NUMBER := 100; -- Annual fee amount
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Applying Annual Fee of ' || v_fee || ' ---');
    OPEN acct_cursor;
    LOOP
        FETCH acct_cursor INTO v_account_id, v_balance;
        EXIT WHEN acct_cursor%NOTFOUND;

        -- Deduct fee only if balance is sufficient
        IF v_balance >= v_fee THEN
            UPDATE Accounts
            SET Balance = Balance - v_fee,
                LastModified = SYSDATE
            WHERE AccountID = v_account_id;

            DBMS_OUTPUT.PUT_LINE('Fee applied to AccountID: ' || v_account_id);
        ELSE
            DBMS_OUTPUT.PUT_LINE('Insufficient balance for AccountID: ' || v_account_id);
        END IF;
    END LOOP;
    CLOSE acct_cursor;
    COMMIT;
END;
/

-- ============================================
-- SCENARIO 3: UpdateLoanInterestRates
-- Apply new interest policy to all loans
-- Example policy: reduce interest by 0.5% for all loans
-- ============================================
DECLARE
    CURSOR loan_cursor IS
        SELECT LoanID, InterestRate FROM Loans;

    v_loan_id     Loans.LoanID%TYPE;
    v_old_rate    Loans.InterestRate%TYPE;
    v_new_rate    NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Updating Loan Interest Rates (reduce by 0.5%) ---');
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_loan_id, v_old_rate;
        EXIT WHEN loan_cursor%NOTFOUND;

        v_new_rate := v_old_rate - 0.5;
        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE LoanID = v_loan_id;

        DBMS_OUTPUT.PUT_LINE('LoanID: ' || v_loan_id || ' | Old Rate: ' || v_old_rate || ' | New Rate: ' || v_new_rate);
    END LOOP;
    CLOSE loan_cursor;
    COMMIT;
END;
/
