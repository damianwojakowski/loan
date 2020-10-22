package com.damian.loan;

public class Loan {
    private Amount amount;
    private LoanPeriod loanPeriod;

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Amount getAmount() {
        return this.amount;
    }

    public void setLoanPeriod(LoanPeriod loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public LoanPeriod getLoanPeriod() {
        return this.loanPeriod;
    }
}
