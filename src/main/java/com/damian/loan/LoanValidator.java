package com.damian.loan;

import com.damian.loan.rules.Rule;

import java.util.ArrayList;
import java.util.List;

public class LoanValidator {

    List<Rule> rules = new ArrayList<Rule>();

    public boolean isValid(Loan loan) {
        for (Rule rule : rules) {
            if (!rule.isValid(loan)) {
                return false;
            };
        }
        return true;
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }
}
