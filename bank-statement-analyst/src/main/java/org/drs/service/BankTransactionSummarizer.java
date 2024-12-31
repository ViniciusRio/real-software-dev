package org.drs.service;

import org.drs.model.BankTransaction;
import org.drs.util.BankSummary;

@FunctionalInterface
public interface BankTransactionSummarizer {
    BankSummary summarize(BankSummary accumulator, BankTransaction bankTransaction);
}
