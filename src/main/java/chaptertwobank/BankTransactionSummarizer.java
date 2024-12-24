package chaptertwobank;

@FunctionalInterface
public interface BankTransactionSummarizer {
    BankSummary summarize(BankSummary accumulator, BankTransaction bankTransaction);
}
