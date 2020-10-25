package com.damian.loan.rules;

import com.damian.loan.LoanApplication;

public interface Rule {
    public boolean isValid(LoanApplication loan);
}
