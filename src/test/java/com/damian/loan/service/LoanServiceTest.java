package com.damian.loan.service;

import com.damian.loan.LoanApplication;
import com.damian.loan.LoanValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoanServiceTest {

    LoanService loanService;

    @BeforeEach
    void setUp() {
        loanService = new LoanService();
        LoanValidator loanValidator = new LoanValidator();

        loanService.setLoanValidator(loanValidator);
    }

    @Test
    void GivenLoanData_CanApplyLoanApplications() {
        LoanService loanService = new LoanService();

        int period = 12;
        long amount = 10000;

        LoanApplication loanApplication = loanService.createLoanApplication(period, amount);
        loanService.apply(loanApplication);
    }
}