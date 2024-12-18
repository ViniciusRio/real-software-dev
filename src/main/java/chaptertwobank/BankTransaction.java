package chaptertwobank;

import java.time.LocalDate;
import java.util.Objects;

public class BankTransaction {
    // método final tem valor unico inicial e não reatribuição
    private final LocalDate date;
    private final double amount;
    private final String description;

    public BankTransaction(final LocalDate date, final double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }
    // final só precisa de get
    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
    @Override
    public String toString() {
        return "BankTransaction{" +
                "date=" + date +
                ", amount=" + amount +
                ", description=" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        BankTransaction that = (BankTransaction) object;
        return Double.compare(that.amount, amount) == 0 &&
                date.equals(that.date) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, description);
    }


}
