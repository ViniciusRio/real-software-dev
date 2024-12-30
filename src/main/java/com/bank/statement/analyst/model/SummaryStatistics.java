package com.bank.statement.analyst.model;

public record SummaryStatistics(
        double sum,
        double max,
        double min,
        double average
) {
}
