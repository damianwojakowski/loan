package com.damian.loan;

import com.damian.loan.rules.MaxLimit;
import com.damian.loan.rules.MinLimit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoanApplicationTests {

    Loan loan;
    LoanValidator validator;

    @BeforeEach
    void init() {
        loan = new Loan();
        validator = new LoanValidator();
    }

    @Test
    void GivenTheLoanAmountIsLessThanMaxLimit_CanTakeALoan() {
        Amount maxLimit = new Amount(5000);
        Amount loanAmount = new Amount(1000);

        validator.addRule(new MaxLimit(maxLimit));
        loan.setAmount(loanAmount);

        assertTrue(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanAmountIsHigherThanMaxLimit_CannotTakeALoan() {
        Amount maxLimit = new Amount(5000);
        Amount loanAmount = new Amount(10000);

        validator.addRule(new MaxLimit(maxLimit));
        loan.setAmount(loanAmount);

        assertFalse(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanAmountIsLowerThanMinimalLimit_CannotTakeALoan() {
        Amount minLimit = new Amount(5000);
        Amount loanAmount = new Amount(1000);

        validator.addRule(new MinLimit(minLimit));
        loan.setAmount(loanAmount);

        assertFalse(validator.isValid(loan));
    }

}
