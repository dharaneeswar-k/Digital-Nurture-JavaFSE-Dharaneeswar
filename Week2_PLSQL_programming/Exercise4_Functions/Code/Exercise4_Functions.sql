SET SERVEROUTPUT ON;


CREATE OR REPLACE FUNCTION CalculateAge (
    p_dob DATE
) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END;
/

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount  NUMBER,
    p_interest_rate NUMBER,
    p_duration_years NUMBER
) RETURN NUMBER IS
    v_monthly_rate NUMBER;
    v_months       NUMBER;
    v_emi          NUMBER;
BEGIN
    v_monthly_rate := p_interest_rate / (12 * 100);
    v_months := p_duration_years * 12;

    v_emi := p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_months)
             / (POWER(1 + v_monthly_rate, v_months) - 1);

    RETURN ROUND(v_emi, 2);
END;
/

-- ========================================
-- FUNCTION 3: HasSufficientBalance
-- ========================================
CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_account_id IN NUMBER,
    p_amount     IN NUMBER
) RETURN BOOLEAN IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_account_id;

    RETURN v_balance >= p_amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/

-- ========================================
-- TESTING ALL FUNCTIONS
-- ========================================
DECLARE
    v_age NUMBER;
    v_emi NUMBER;
    v_has_balance BOOLEAN;
BEGIN
    -- Scenario 1: Calculate age
    v_age := CalculateAge(TO_DATE('1990-06-15', 'YYYY-MM-DD'));
    DBMS_OUTPUT.PUT_LINE('Age is: ' || v_age);

    -- Scenario 2: Calculate monthly installment
    v_emi := CalculateMonthlyInstallment(50000, 8.5, 5); -- 50k loan, 8.5% interest, 5 years
    DBMS_OUTPUT.PUT_LINE('Monthly installment is: ' || v_emi);

    -- Scenario 3: Check sufficient balance
    v_has_balance := HasSufficientBalance(1, 1000);
    IF v_has_balance THEN
        DBMS_OUTPUT.PUT_LINE('Account 1 has sufficient balance.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Account 1 does NOT have sufficient balance.');
    END IF;
END;
/
