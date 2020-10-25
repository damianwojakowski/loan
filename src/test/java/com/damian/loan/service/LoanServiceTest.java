package com.damian.loan.service;

import com.damian.loan.LoanApplication;
import com.damian.loan.LoanValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanServiceTest {

//    LoanService loanService;

//    @BeforeEach
//    void setUp() {
//        loanService = new LoanService();
//    }

    @Test
    void GivenLoanData_CanApplyLoanApplications() {
        LoanService loanService = new LoanService();
        LoanApplication loanApplication = new LoanApplication();
        LoanValidator loanValidator = new LoanValidator();

        loanService.setLoanApplication();
        loanService.setLoanValidator();

        long loanId = 1;
        int period = 12;
        long amount = 10000;

        loanService.applyForLoan(loanId, period, amount);
    }
}