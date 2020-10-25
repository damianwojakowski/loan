package com.damian.loan.rules;

import com.damian.loan.attributes.Amount;
import com.damian.loan.LoanApplication;

public class AmountLimits implements Rule {

    private Amount maxLimit;
    private Amount minLimit;

    public AmountLimits(Amount minLimit, Amount maxLimit) {
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
    }

    @Override
    public boolean isValid(LoanApplication loan) {
        return maxAmount(loan) && minAmount(loan);
    }

    private boolean maxAmount(LoanApplication loan) {
        return loan.getAmount().getValue() <= maxLimit.getValue();
    }

    private boolean minAmount(LoanApplication loan) {
        return loan.getAmount().getValue() >= minLimit.getValue();
    }
}
