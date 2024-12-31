package org.drs.exporter;

import org.drs.model.SummaryStatistics;

public interface Exporter {
    /*
    * evitar usar void
    * */

    String export(SummaryStatistics summaryStatistics);
}
