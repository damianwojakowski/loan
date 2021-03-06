package com.damian.loan;

import com.damian.loan.attributes.Amount;
import com.damian.loan.attributes.LoanPeriodInInstalments;
import com.damian.loan.rules.LoanPeriodLimits;
import com.damian.loan.rules.AmountLimits;
import com.damian.loan.rules.OvernightLimits;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LoanApplicationIntegrationTest {

    LoanApplication loan;
    LoanValidator validator;

    @BeforeEach
    void setUp() {
        loan = new LoanApplication();
        validator = new LoanValidator();
    }

    @Test
    void GivenTheLoanAmountIsLessThanMaxLimit_CanTakeALoan() {
        Amount minLimit = new Amount(1000);
        Amount maxLimit = new Amount(5000);
        Amount loanAmount = new Amount(1000);

        validator.addRule(new AmountLimits(minLimit, maxLimit));
        loan.setAmount(loanAmount);

        assertTrue(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanAmountEqualsMaxLimit_CanTakeALoan() {
        Amount minLimit = new Amount(1000);
        Amount maxLimit = new Amount(5000);
        Amount loanAmount = new Amount(5000);

        validator.addRule(new AmountLimits(minLimit, maxLimit));
        loan.setAmount(loanAmount);

        assertTrue(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanAmountIsHigherThanMaxLimit_CannotTakeALoan() {
        Amount minLimit = new Amount(1000);
        Amount maxLimit = new Amount(5000);
        Amount loanAmount = new Amount(10000);

        validator.addRule(new AmountLimits(minLimit, maxLimit));
        loan.setAmount(loanAmount);

        assertFalse(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanAmountIsLowerThanMinimalLimit_CannotTakeALoan() {
        Amount minLimit = new Amount(5000);
        Amount maxLimit = new Amount(10000);
        Amount loanAmount = new Amount(1000);

        validator.addRule(new AmountLimits(minLimit, maxLimit));
        loan.setAmount(loanAmount);

        assertFalse(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanAmountEqualsMinimalLimit_CanTakeALoan() {
        Amount minLimit = new Amount(5000);
        Amount maxLimit = new Amount(10000);
        Amount loanAmount = new Amount(5000);

        validator.addRule(new AmountLimits(minLimit, maxLimit));
        loan.setAmount(loanAmount);

        assertTrue(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanAmountIsHigherThanMinimalLimit_CanTakeALoan() {
        Amount minLimit = new Amount(5000);
        Amount maxLimit = new Amount(15000);
        Amount loanAmount = new Amount(10000);

        validator.addRule(new AmountLimits(minLimit, maxLimit));
        loan.setAmount(loanAmount);

        assertTrue(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanPeriodIsShorterThanMinimalSetting_CannotTakeALoan() {
        LoanPeriodInInstalments minLimit = new LoanPeriodInInstalments(6);
        LoanPeriodInInstalments max = new LoanPeriodInInstalments(60);
        LoanPeriodInInstalments chosenPeriod = new LoanPeriodInInstalments(3);

        validator.addRule(new LoanPeriodLimits(minLimit, max));
        loan.setLoanPeriod(chosenPeriod);

        assertFalse(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanPeriodIsLongerThanMinimalSetting_CanTakeALoan() {
        LoanPeriodInInstalments minLimit = new LoanPeriodInInstalments(6);
        LoanPeriodInInstalments max = new LoanPeriodInInstalments(60);
        LoanPeriodInInstalments chosenPeriod = new LoanPeriodInInstalments(13);

        validator.addRule(new LoanPeriodLimits(minLimit, max));
        loan.setLoanPeriod(chosenPeriod);

        assertTrue(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanPeriodEqualsMinimalSetting_CanTakeALoan() {
        LoanPeriodInInstalments minLimit = new LoanPeriodInInstalments(6);
        LoanPeriodInInstalments max = new LoanPeriodInInstalments(60);
        LoanPeriodInInstalments chosenPeriod = new LoanPeriodInInstalments(6);

        validator.addRule(new LoanPeriodLimits(minLimit, max));
        loan.setLoanPeriod(chosenPeriod);

        assertTrue(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanPeriodIsLongerThanMaximalSetting_CannotTakeALoan() {
        LoanPeriodInInstalments min = new LoanPeriodInInstalments(6);
        LoanPeriodInInstalments max = new LoanPeriodInInstalments(60);
        LoanPeriodInInstalments chosenPeriod = new LoanPeriodInInstalments(72);

        validator.addRule(new LoanPeriodLimits(min, max));
        loan.setLoanPeriod(chosenPeriod);

        assertFalse(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanPeriodIsLowerThanMaximalSetting_CanTakeALoan() {
        LoanPeriodInInstalments min = new LoanPeriodInInstalments(6);
        LoanPeriodInInstalments max = new LoanPeriodInInstalments(60);
        LoanPeriodInInstalments chosenPeriod = new LoanPeriodInInstalments(24);

        validator.addRule(new LoanPeriodLimits(min, max));
        loan.setLoanPeriod(chosenPeriod);

        assertTrue(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanPeriodEqualsMaximalSetting_CanTakeALoan() {
        LoanPeriodInInstalments min = new LoanPeriodInInstalments(6);
        LoanPeriodInInstalments max = new LoanPeriodInInstalments(60);
        LoanPeriodInInstalments chosenPeriod = new LoanPeriodInInstalments(60);

        validator.addRule(new LoanPeriodLimits(min, max));
        loan.setLoanPeriod(chosenPeriod);

        assertTrue(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanAmountEqualsMaximalAndIsOvernight_CannotTakeALoan() {
        Amount max = new Amount(20000);
        // 2020/1/1 - 02:30 AM
        LocalDateTime creationTime = LocalDateTime.of(2020, 1, 1, 2, 30);

        validator.addRule(new OvernightLimits(max));
        loan.setCreationTime(creationTime);
        loan.setAmount(new Amount(20000));

        assertFalse(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanAmountIsLessThanMaximalAndIsOvernight_CanTakeALoan() {
        Amount max = new Amount(20000);
        // 2020/1/1 - 02:30 AM
        LocalDateTime creationTime = LocalDateTime.of(2020, 1, 1, 2, 30);

        validator.addRule(new OvernightLimits(max));
        loan.setCreationTime(creationTime);
        loan.setAmount(new Amount(15000));

        assertTrue(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanAmountIsMaximalAndIsNotOvernight_CanTakeALoan() {
        Amount max = new Amount(20000);
        // 2020/1/1 - 10:30 AM
        LocalDateTime creationTime = LocalDateTime.of(2020, 1, 1, 10, 30);

        validator.addRule(new OvernightLimits(max));
        loan.setCreationTime(creationTime);
        loan.setAmount(new Amount(15000));

        assertTrue(validator.isValid(loan));
    }



}
