package com.damian.loan.rules;

import com.damian.loan.Amount;
import com.damian.loan.Loan;

public class MinLimit implements Rule {

    private Amount minLimit;

    public MinLimit(Amount minLimit) {
        this.minLimit = minLimit;
    }

    @Override
    public boolean isValida(Loan loan) {
        return loan.getAmount().getValue() >= minLimit.getValue();
    }
}
