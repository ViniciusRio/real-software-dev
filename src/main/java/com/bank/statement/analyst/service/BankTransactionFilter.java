package com.bank.statement.analyst.service;

import com.bank.statement.analyst.model.BankTransaction;

@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
