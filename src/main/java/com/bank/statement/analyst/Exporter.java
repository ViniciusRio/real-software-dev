package com.bank.statement.analyst;

public interface Exporter {
    /*
    * evitar usar void
    * */

    String export(SummaryStatistics summaryStatistics);
}
