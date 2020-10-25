package com.damian.loan;

import com.damian.loan.attributes.Amount;
import com.damian.loan.attributes.LoanPeriodInInstalments;
import com.damian.loan.rules.LoanPeriod;
import com.damian.loan.rules.MaxAmountLimit;
import com.damian.loan.rules.MinAmountLimit;
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

        validator.addRule(new MaxAmountLimit(maxLimit));
        loan.setAmount(loanAmount);

        assertTrue(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanAmountIsHigherThanMaxLimit_CannotTakeALoan() {
        Amount maxLimit = new Amount(5000);
        Amount loanAmount = new Amount(10000);

        validator.addRule(new MaxAmountLimit(maxLimit));
        loan.setAmount(loanAmount);

        assertFalse(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanAmountIsLowerThanMinimalLimit_CannotTakeALoan() {
        Amount minLimit = new Amount(5000);
        Amount loanAmount = new Amount(1000);

        validator.addRule(new MinAmountLimit(minLimit));
        loan.setAmount(loanAmount);

        assertFalse(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanAmountIsHigherThanMinimalLimit_CanTakeALoan() {
        Amount minLimit = new Amount(5000);
        Amount loanAmount = new Amount(10000);

        validator.addRule(new MinAmountLimit(minLimit));
        loan.setAmount(loanAmount);

        assertTrue(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanPeriodIsShorterThanMinimalSetting_CannotTakeALoan() {
        LoanPeriodInInstalments minLimit = new LoanPeriodInInstalments(6);
        LoanPeriodInInstalments max = new LoanPeriodInInstalments(60);
        LoanPeriodInInstalments chosenPeriod = new LoanPeriodInInstalments(3);

        validator.addRule(new LoanPeriod(minLimit, max));
        loan.setLoanPeriod(chosenPeriod);

        assertFalse(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanPeriodIsLongerThanMinimalSetting_CanTakeALoan() {
        LoanPeriodInInstalments minLimit = new LoanPeriodInInstalments(6);
        LoanPeriodInInstalments max = new LoanPeriodInInstalments(60);
        LoanPeriodInInstalments chosenPeriod = new LoanPeriodInInstalments(13);

        validator.addRule(new LoanPeriod(minLimit, max));
        loan.setLoanPeriod(chosenPeriod);

        assertTrue(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanPeriodEqualsMinimalSetting_CanTakeALoan() {
        LoanPeriodInInstalments minLimit = new LoanPeriodInInstalments(6);
        LoanPeriodInInstalments max = new LoanPeriodInInstalments(60);
        LoanPeriodInInstalments chosenPeriod = new LoanPeriodInInstalments(6);

        validator.addRule(new LoanPeriod(minLimit, max));
        loan.setLoanPeriod(chosenPeriod);

        assertTrue(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanPeriodIsLongerThanMaximalSetting_CannotTakeALoan() {
        LoanPeriodInInstalments min = new LoanPeriodInInstalments(6);
        LoanPeriodInInstalments max = new LoanPeriodInInstalments(60);
        LoanPeriodInInstalments chosenPeriod = new LoanPeriodInInstalments(72);

        validator.addRule(new LoanPeriod(min, max));
        loan.setLoanPeriod(chosenPeriod);

        assertFalse(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanPeriodIsLowerThanMaximalSetting_CanTakeALoan() {
        LoanPeriodInInstalments min = new LoanPeriodInInstalments(6);
        LoanPeriodInInstalments max = new LoanPeriodInInstalments(60);
        LoanPeriodInInstalments chosenPeriod = new LoanPeriodInInstalments(24);

        validator.addRule(new LoanPeriod(min, max));
        loan.setLoanPeriod(chosenPeriod);

        assertTrue(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanPeriodEqualsMaximalSetting_CanTakeALoan() {
        LoanPeriodInInstalments min = new LoanPeriodInInstalments(6);
        LoanPeriodInInstalments max = new LoanPeriodInInstalments(60);
        LoanPeriodInInstalments chosenPeriod = new LoanPeriodInInstalments(60);

        validator.addRule(new LoanPeriod(min, max));
        loan.setLoanPeriod(chosenPeriod);

        assertTrue(validator.isValid(loan));
    }

}