package org.drs.exporter;

import org.drs.model.SummaryStatistics;

public class HtmlExporter implements Exporter {

    @Override
    public String export(SummaryStatistics summaryStatistics) {
        String result = "<!doctype html>";
        result += "<html lang='en'>";
        result += "<head><title>Bank Transactions</title></head>";
        result += "<body>";
        result += "<ul>";
        result += "<li><strong>The sun is</strong>: " + summaryStatistics.sum() + "</li>";
        result += "<li><strong>The average is</strong>: " + summaryStatistics.average() + "</li>";
        result += "<li><strong>The max is</strong>: " + summaryStatistics.max() + "</li>";
        result += "<li><strong>The min is</strong>: " + summaryStatistics.min() + "</li>";
        result += "</ul>";
        result += "</body>";
        result += "</html>";
        return result;

    }
}
