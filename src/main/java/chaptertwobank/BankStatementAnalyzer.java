package chaptertwobank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public void analyze(final String fileName, final BankStatementParser parser) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bancoTransactions = parser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bancoTransactions);

        collectSummary(bankStatementProcessor);


    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transaction is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("Transactions in January " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("Transactions in February " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total of salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));

        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 1, 15);
        System.out.println("The max debit between " +
                startDate +
                " e " +
                endDate +
                ": " +
                bankStatementProcessor.calculateMaxAmountNegativeBetweenDates(startDate, endDate));
    }
}
