package com.damian.loan;

public class Settings {
    private static final long MIN_LOAN_AMOUNT = 1000;
    private static final long MAX_LOAN_AMOUNT = 10000;

    private static final int MIN_LOAN_PERIOD = 10000;
    private static final int MAX_LOAN_PERIOD = 10000;

    private static final double LOAN_INTEREST = 7;
    private static final int REPAYMENT_DATE_EXTENSION_LIMIT = 20;

    public static long getMinLoanAmount() {
        return MIN_LOAN_AMOUNT;
    }

    public static long getMaxLoanAmount() {
        return MAX_LOAN_AMOUNT;
    }

    public static int getMinLoanPeriod() {
        return MIN_LOAN_PERIOD;
    }

    public static int getMaxLoanPeriod() {
        return MAX_LOAN_PERIOD;
    }

    public static double getLoanInterest() {
        return LOAN_INTEREST;
    }

    public static int getRepaymentDateExtensionLimit() {
        return REPAYMENT_DATE_EXTENSION_LIMIT;
    }
}
