package com.damian.loan.repository;

import com.damian.loan.model.LoanDaoImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryLoanRepository implements LoanRepository {

    List<LoanDaoImpl> loanDao = new ArrayList();
    long id = 1;

    @Override
    public void save(long amount, int period, LocalDateTime creationDate) {
        LoanDaoImpl loan = new LoanDaoImpl();
        loan.setAmount(amount);
        loan.setPeriod(period);
        loan.setCreatedAt(creationDate);
        loan.setId(id);
        id++;

        loanDao.add(loan);
    }
}
