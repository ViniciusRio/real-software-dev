package org.drs.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BankCSVRowValidator {
    public static final int EXPECTED_COLUMNS = 3;

    public static void validateColumns(String[] columns, String line) {
        if (columns.length != EXPECTED_COLUMNS) {
            throw new IllegalArgumentException("Wrong number of columns: " + line);
        }
    }

    public static LocalDate validateDate(String date, DateTimeFormatter formatter) {
        try {
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid Date: " + date, e);
        }
    }

    public static double validateAmount(String amount) {
        try {
            return Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid amount: " + amount, e);
        }
    }
}
