package com.damian.loan.rules;

import com.damian.loan.attributes.Amount;
import com.damian.loan.LoanApplication;

public class MaxLimit implements Rule {

    private Amount maxLimit;

    public MaxLimit(Amount maxLimit) {
        this.maxLimit = maxLimit;
    }

    @Override
    public boolean isValid(LoanApplication loan) {
        return loan.getAmount().getValue() <= maxLimit.getValue();
    }
}
