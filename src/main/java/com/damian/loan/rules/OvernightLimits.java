package com.damian.loan.rules;

import com.damian.loan.LoanApplication;
import com.damian.loan.attributes.Amount;

public class OvernightLimits implements Rule {

    private Amount maxLimit;

    public OvernightLimits(Amount maxLimit) {
        this.maxLimit = maxLimit;
    }

    @Override
    public boolean isValid(LoanApplication loan) {
        return !(isMaxAmountLimit(loan) && isOvernight(loan));
    }

    private boolean isMaxAmountLimit(LoanApplication loan) {
        return loan.getAmount().getValue() == maxLimit.getValue();
    }

    /**
     * Between 00:00 and 06:00 as requirements say
     */
    private boolean isOvernight(LoanApplication loan) {
        return loan.getCreationDate().getHour() <= 6;
    }
}
