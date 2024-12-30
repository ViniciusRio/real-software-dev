package com.bank.statement.analyst.exporter;

import com.bank.statement.analyst.model.SummaryStatistics;

public class JsonExporter implements Exporter {
    @Override
    public String export(SummaryStatistics summaryStatistics) {
        String result = "{\n";
        result += "  \"summaryStatistics\": {\n";
        result += "    \"sum\": " + summaryStatistics.sum() + ",\n";
        result += "    \"average\": " + summaryStatistics.average() + ",\n";
        result += "    \"max\": " + summaryStatistics.max() + ",\n";
        result += "    \"min\": " + summaryStatistics.min() + "\n";
        result += "  }\n";
        result += "}";
        return result;
    }

}
