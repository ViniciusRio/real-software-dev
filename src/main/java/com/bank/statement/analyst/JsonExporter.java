package com.bank.statement.analyst;

public class JsonExporter implements Exporter {
    @Override
    public String export(SummaryStatistics summaryStatistics) {
        String result = "{\n";
        result += "  \"summaryStatistics\": {\n";
        result += "    \"sum\": " + summaryStatistics.getSum() + ",\n";
        result += "    \"average\": " + summaryStatistics.getAverage() + ",\n";
        result += "    \"max\": " + summaryStatistics.getMax() + ",\n";
        result += "    \"min\": " + summaryStatistics.getMin() + "\n";
        result += "  }\n";
        result += "}";
        return result;
    }

}
