package com.damian.loan.rules;

import com.damian.loan.Amount;
import com.damian.loan.Loan;

public class MaxLimit implements Rule {

    private Amount maxLimit;

    public MaxLimit(Amount maxLimit) {
        this.maxLimit = maxLimit;
    }

    @Override
    public boolean isValida(Loan loan) {
        if (loan.getAmount().getValue() > maxLimit.getValue()) {
            return false;
        } else {
            return true;
        }
    }
}
