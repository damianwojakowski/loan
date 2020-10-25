package com.damian.loan.service;

import com.damian.loan.LoanApplication;
import com.damian.loan.Validator;
import com.damian.loan.attributes.Amount;
import com.damian.loan.attributes.LoanPeriodInInstalments;

import java.time.LocalDateTime;

public class LoanService {
    Validator loanValidator;

    public void setLoanValidator(Validator loanValidator) {
        this.loanValidator = loanValidator;
    }

    public LoanApplication createLoanApplication(int period, long amount) {
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setAmount(new Amount(amount));
        loanApplication.setLoanPeriod(new LoanPeriodInInstalments(period));
        loanApplication.setCreationTime(LocalDateTime.now());

        return loanApplication;
    }

    public boolean apply(LoanApplication loanApplication) {
        if (this.loanValidator.isValid(loanApplication)) {
            return true;
        } else {
            return false;
        }
    }
}
