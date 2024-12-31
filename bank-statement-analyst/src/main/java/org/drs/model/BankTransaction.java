package org.drs.model;

import java.time.LocalDate;

public record BankTransaction(LocalDate date, double amount, String description) {
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


}
