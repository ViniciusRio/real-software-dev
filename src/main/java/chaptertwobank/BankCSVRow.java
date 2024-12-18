package chaptertwobank;

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

        if (!isNumeric(columns[1])) {
            throw new NumberFormatException("Amount is not numeric");
        }

        return new BankCSVRow(columns[0], columns[1], columns[2]);
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
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
