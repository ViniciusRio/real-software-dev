package com.bank.statement.analyst.service;

import com.bank.statement.analyst.model.BankTransaction;
import com.bank.statement.analyst.util.BankSummary;

@FunctionalInterface
public interface BankTransactionSummarizer {
    BankSummary summarize(BankSummary accumulator, BankTransaction bankTransaction);
}
