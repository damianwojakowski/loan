package com.damian.loan.rules;

import com.damian.loan.LoanApplication;
import com.damian.loan.attributes.LoanPeriodInInstalments;

public class MinLoanPeriod implements Rule {

    LoanPeriodInInstalments minLimit;

    public MinLoanPeriod(LoanPeriodInInstalments minLimit) {
        this.minLimit = minLimit;
    }

    @Override
    public boolean isValid(LoanApplication loan) {
        return loan.getLoanPeriod().getValue() >= minLimit.getValue();
    }
}
