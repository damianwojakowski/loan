package com.damian.loan.rules;

import com.damian.loan.LoanApplication;
import com.damian.loan.attributes.LoanPeriod;

public class MinLoanPeriod implements Rule {

    LoanPeriod minLimit;

    public MinLoanPeriod(LoanPeriod minLimit) {
        this.minLimit = minLimit;
    }

    @Override
    public boolean isValid(LoanApplication loan) {
        return loan.getLoanPeriod().getValue() >= minLimit.getValue();
    }
}
