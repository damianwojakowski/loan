package com.damian.loan.rules;

import com.damian.loan.attributes.Amount;
import com.damian.loan.LoanApplication;

public class MinAmountLimit implements Rule {

    private Amount minLimit;

    public MinAmountLimit(Amount minLimit) {
        this.minLimit = minLimit;
    }

    @Override
    public boolean isValid(LoanApplication loan) {
        return loan.getAmount().getValue() >= minLimit.getValue();
    }
}