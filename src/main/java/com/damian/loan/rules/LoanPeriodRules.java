package com.damian.loan.rules;

import com.damian.loan.LoanApplication;
import com.damian.loan.attributes.LoanPeriodInInstalments;

public class LoanPeriod implements Rule {

    LoanPeriodInInstalments minLimit;
    LoanPeriodInInstalments maxLimit;

    public LoanPeriod(LoanPeriodInInstalments minLimit, LoanPeriodInInstalments maxLimit) {
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
    }

    @Override
    public boolean isValid(LoanApplication loan) {
        return isValidForMinLimit(loan) && isValidForMaxLimit(loan);
    }

    private boolean isValidForMinLimit(LoanApplication loan) {
        return loan.getLoanPeriod().getValue() >= minLimit.getValue();
    }

    private boolean isValidForMaxLimit(LoanApplication loan) {
        return loan.getLoanPeriod().getValue() <= maxLimit.getValue();
    }
}
