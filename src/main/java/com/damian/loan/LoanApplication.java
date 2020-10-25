package com.damian.loan;

import com.damian.loan.attributes.Amount;
import com.damian.loan.attributes.LoanPeriodInInstalments;

import java.time.LocalDateTime;

public class LoanApplication {
    private Amount amount;
    private LoanPeriodInInstalments loanPeriod;
    private LocalDateTime creationDate;

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Amount getAmount() {
        return this.amount;
    }

    public void setLoanPeriod(LoanPeriodInInstalments loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public LoanPeriodInInstalments getLoanPeriod() {
        return this.loanPeriod;
    }

    public void setCreationTime(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }
}
