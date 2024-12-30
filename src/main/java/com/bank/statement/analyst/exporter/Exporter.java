package com.bank.statement.analyst.exporter;

import com.bank.statement.analyst.model.SummaryStatistics;

public interface Exporter {
    /*
    * evitar usar void
    * */

    String export(SummaryStatistics summaryStatistics);
}
