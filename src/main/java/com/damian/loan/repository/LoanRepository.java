package com.damian.loan.repository;

import com.damian.loan.attributes.Amount;
import com.damian.loan.attributes.LoanPeriodInInstalments;

import java.time.LocalDateTime;

public interface LoanRepository {

    void save(long amount, int period, LocalDateTime creationDate);
}
