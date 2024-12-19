package chaptertwobank;

import java.time.LocalDate;
import java.time.Month;
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

    public double calculateTotalInMonth(final Month month) {
        double totalAmount = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                totalAmount += bankTransaction.getAmount();
            }
        }
        return totalAmount;
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
}
