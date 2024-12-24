package chaptertwobank;

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

        final LocalDate date = BankCSVRow.validateDate(bankCSVRow.getDate(), DATE_PATTERN);
        final double amount = BankCSVRow.validateAmount(bankCSVRow.getAmount());
        final String description = bankCSVRow.getDescription();

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
