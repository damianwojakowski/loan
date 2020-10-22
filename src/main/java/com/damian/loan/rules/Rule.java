package com.damian.loan.rules;

import com.damian.loan.Loan;

public interface Rule {
    public boolean isValid(Loan loan);
}
