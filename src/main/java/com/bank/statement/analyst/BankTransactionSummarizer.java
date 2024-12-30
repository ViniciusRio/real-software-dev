package com.bank.statement.analyst;

@FunctionalInterface
public interface BankTransactionSummarizer {
    BankSummary summarize(BankSummary accumulator, BankTransaction bankTransaction);
}
