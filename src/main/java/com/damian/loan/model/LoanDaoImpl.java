package com.damian.loan.model;

import java.time.LocalDateTime;

public class LoanDaoImpl implements LoanDao {
    private Long id;
    private Long amount;
    private int period;
    private LocalDateTime createdAt;
    private boolean isPeriodExtended;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
