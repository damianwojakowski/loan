package com.damian.loan;

import com.damian.loan.rules.MaxLimit;
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
        Amount amount = new Amount(1000);

        validator.addRule(new MaxLimit(maxLimit));
        loan.setAmount(amount);

        assertTrue(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanAmountIsHitherThanMaxLimit_CannotTakeALoan() {
        Amount maxLimit = new Amount(5000);
        Amount amount = new Amount(10000);

        validator.addRule(new MaxLimit(maxLimit));
        loan.setAmount(amount);

        assertFalse(validator.isValid(loan));
    }

}
