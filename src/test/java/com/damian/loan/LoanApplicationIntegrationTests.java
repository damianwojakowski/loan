package com.damian.loan;

import com.damian.loan.attributes.Amount;
import com.damian.loan.attributes.LoanPeriod;
import com.damian.loan.rules.MaxLimit;
import com.damian.loan.rules.MinLimit;
import com.damian.loan.rules.MinLoanPeriod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoanApplicationIntegrationTests {

    LoanApplication loan;
    LoanValidator validator;

    @BeforeEach
    void setUp() {
        loan = new LoanApplication();
        validator = new LoanValidator();
    }

    @Test
    void GivenTheLoanAmountIsLessThanMaxLimit_CanTakeALoan() {
        Amount maxLimit = new Amount(5000);
        Amount loanAmount = new Amount(1000);

        validator.addRule(new MaxLimit(maxLimit));
        loan.setAmount(loanAmount);

        assertTrue(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanAmountIsHigherThanMaxLimit_CannotTakeALoan() {
        Amount maxLimit = new Amount(5000);
        Amount loanAmount = new Amount(10000);

        validator.addRule(new MaxLimit(maxLimit));
        loan.setAmount(loanAmount);

        assertFalse(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanAmountIsLowerThanMinimalLimit_CannotTakeALoan() {
        Amount minLimit = new Amount(5000);
        Amount loanAmount = new Amount(1000);

        validator.addRule(new MinLimit(minLimit));
        loan.setAmount(loanAmount);

        assertFalse(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanAmountIsHigherThanMinimalLimit_CanTakeALoan() {
        Amount minLimit = new Amount(5000);
        Amount loanAmount = new Amount(10000);

        validator.addRule(new MinLimit(minLimit));
        loan.setAmount(loanAmount);

        assertTrue(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanPeriodIsShorterThanMinimalSetting_CannotTakeALoan() {
        LoanPeriod minLimit = new LoanPeriod(12);
        LoanPeriod chosenPeriod = new LoanPeriod(10);

        validator.addRule(new MinLoanPeriod(minLimit));
        loan.setLoanPeriod(chosenPeriod);

        assertFalse(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanPeriodIsLongerOrEqualsMinimalSetting_CanTakeALoan() {
        LoanPeriod minLimit = new LoanPeriod(12);
        LoanPeriod chosenPeriod = new LoanPeriod(13);

        validator.addRule(new MinLoanPeriod(minLimit));
        loan.setLoanPeriod(chosenPeriod);

        assertTrue(validator.isValid(loan));
    }

}
