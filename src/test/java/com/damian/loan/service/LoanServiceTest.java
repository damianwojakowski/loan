package com.damian.loan.service;

import com.damian.loan.LoanApplication;
import com.damian.loan.LoanValidator;
import com.damian.loan.attributes.Amount;
import com.damian.loan.attributes.LoanPeriodInInstalments;
import com.damian.loan.rules.AmountLimits;
import com.damian.loan.rules.LoanPeriodLimits;
import com.damian.loan.rules.OvernightLimits;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoanServiceTest {

    LoanService loanService;

    @BeforeEach
    void setUp() {
        loanService = new LoanService();
        loanService.setLoanValidator(setUpValidator());
    }

    @Test
    void GivenLoanData_CanApplyLoanApplications() {
        int period = 12;
        long amount = 10000;

        LoanApplication loanApplication = loanService.createLoanApplication(period, amount);
        loanService.apply(loanApplication);
    }

    private LoanValidator setUpValidator() {
        LoanValidator loanValidator = new LoanValidator();
        loanValidator.addRule(new AmountLimits(new Amount(1000), new Amount(50000)));
        loanValidator.addRule(new LoanPeriodLimits(new LoanPeriodInInstalments(6), new LoanPeriodInInstalments(60)));
        loanValidator.addRule(new OvernightLimits(new Amount(1000)));

        return loanValidator;
    }
}