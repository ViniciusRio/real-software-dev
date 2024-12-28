package chaptertwobank;

public class BankCSVRow {
    private static final int DATE_INDEX = 0;
    private static final int AMOUNT_INDEX = 1;
    private static final int DESCRIPTION_INDEX = 2;

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
        BankCSVRowValidator.validateColumns(columns, line);

        return new BankCSVRow(columns[DATE_INDEX], columns[AMOUNT_INDEX], columns[DESCRIPTION_INDEX]);
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
