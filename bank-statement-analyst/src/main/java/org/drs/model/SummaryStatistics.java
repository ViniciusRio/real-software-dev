package org.drs.model;

public record SummaryStatistics(
        double sum,
        double max,
        double min,
        double average
) {
}
