package com.damian.loan;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoanApplicationTests {

    @Test
    void GivenTheLoanAmountIsLessThanMaxLimit_CanTakeALoan() {
        int maxLimit = 5000;
        int amount = 1000;

        Loan loan = new Loan();
        LoanValidator validator = new LoanValidator();

        loan.setAmount(amount);
        assertTrue(validator.isValid(loan));
    }

    @Test
    void GivenTheLoanAmountIsHitherThanMaxLimit_CannotTakeALoan() {
        int maxLimit = 5000;
        int amount = 10000;

        Loan loan = new Loan();
        LoanValidator validator = new LoanValidator();

        loan.setAmount(amount);
        assertFalse(validator.isValid(loan));
    }

}
