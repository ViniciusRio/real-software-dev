package chaptertwobank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BankCSVRow {
    private final String date;
    private final String amount;
    private final String description;

    public BankCSVRow(String date, String amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public static BankCSVRow fromLine(String line) {
        String[] columns = line.split(",");
        if (columns.length != 3) {
            throw new IllegalArgumentException("Wrong number of columns: " + line);
        }

        return new BankCSVRow(columns[0], columns[1], columns[2]);
    }

    public static LocalDate validateDate(String date, DateTimeFormatter formatter) {
        try {
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException("Invalid Date: " + date, date, e.getErrorIndex(), e);
        }
    }

    public static double validateAmount(String amount) {
        try {
            return Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid amount: " + amount);
        }
    }

    public String getDate() {
        return date;
    }

    public String getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
