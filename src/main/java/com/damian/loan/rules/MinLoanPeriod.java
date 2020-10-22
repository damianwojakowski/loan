package com.damian.loan.rules;

import com.damian.loan.Loan;
import com.damian.loan.LoanPeriod;

public class MinLoanPeriod implements Rule {

    LoanPeriod minLimit;

    public MinLoanPeriod(LoanPeriod minLimit) {
        this.minLimit = minLimit;
    }

    @Override
    public boolean isValid(Loan loan) {
        return loan.getLoanPeriod().getValue() >= minLimit.getValue();
    }
}
