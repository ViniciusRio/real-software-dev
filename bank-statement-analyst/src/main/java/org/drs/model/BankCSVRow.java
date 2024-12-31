package org.drs.model;

import org.drs.validator.BankCSVRowValidator;

public record BankCSVRow(String date, String amount, String description) {
    private static final int DATE_INDEX = 0;
    private static final int AMOUNT_INDEX = 1;
    private static final int DESCRIPTION_INDEX = 2;

    public static BankCSVRow fromLine(String line) {
        String[] columns = line.split(",");
        BankCSVRowValidator.validateColumns(columns, line);

        return new BankCSVRow(columns[DATE_INDEX], columns[AMOUNT_INDEX], columns[DESCRIPTION_INDEX]);
    }
}
