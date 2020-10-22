package com.damian.loan.rules;

import com.damian.loan.Loan;

public class MaxLimit implements Rule {

    private int maxLimit;

    public MaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    @Override
    public boolean isValida(Loan loan) {
        if (loan.getAmount() > maxLimit) {
            return false;
        } else {
            return true;
        }
    }
}
