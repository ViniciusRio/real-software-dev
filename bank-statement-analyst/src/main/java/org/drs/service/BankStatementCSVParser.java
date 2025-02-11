package org.drs.service;

import org.drs.model.BankCSVRow;
import org.drs.validator.BankCSVRowValidator;
import org.drs.model.BankTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser implements BankStatementParser {
    private static final DateTimeFormatter DATE_PATTERN
            = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    @Override
    public BankTransaction parseFrom(String line) {
        BankCSVRow bankCSVRow = BankCSVRow.fromLine(line);

        LocalDate date = BankCSVRowValidator.validateDate(bankCSVRow.date(), DATE_PATTERN);
        double amount = BankCSVRowValidator.validateAmount(bankCSVRow.amount());
        String description = bankCSVRow.description();

        return new BankTransaction(date, amount, description);
    }

    public List<BankTransaction> parseLinesFrom(final List<String> lines) {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for (final String line: lines) {
            bankTransactions.add(parseFrom(line));

        }
        return bankTransactions;
    }
}
