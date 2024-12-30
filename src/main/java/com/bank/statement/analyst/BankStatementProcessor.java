package com.bank.statement.analyst;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        double totalAmount = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            totalAmount += bankTransaction.getAmount();
        }
        return totalAmount;
    }

    public BankSummary calculateTotalInMonth(final Month month) {
        return summarizeTransactions((accumulator, bankTransaction) -> {
           if (bankTransaction.getDate().getMonth().equals(month)) {
               double total = accumulator.getTotal() + bankTransaction.getAmount();
               return new BankSummary(total);
           }

           return accumulator;
        });
    }

    public double calculateTotalForCategory(final String category) {
        double totalAmount = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDescription().equals(category)) {
                totalAmount += bankTransaction.getAmount();
            }
        }
        return totalAmount;
    }

    public double calculateMaxAmountNegativeBetweenDates(final LocalDate startDate, final LocalDate endDate) {
        return bankTransactions.stream()
                //garente que as datas não sejam antes ou depois do range
                .filter(transaction ->
                        !transaction.getDate().isBefore(startDate) && !transaction.getDate().isAfter(endDate))
                // pega cada valor
                .mapToDouble(BankTransaction::getAmount)
                // pega apenas os negativos
                .filter(amount -> amount < 0)
                // pega o menor valor (mais distante de zero)
                .min()
                .orElse(0);
    }

    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> bankTransactions2 = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransactionFilter.test(bankTransaction)) {
                bankTransactions2.add(bankTransaction);
            }
        }
        return bankTransactions2;
    }

    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
        return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);

    }

    public BankSummary summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
        BankSummary result = new BankSummary(0);
        for (final BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }

        return result;

    }
}
