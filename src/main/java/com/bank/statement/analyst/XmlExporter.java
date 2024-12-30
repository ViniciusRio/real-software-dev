package com.bank.statement.analyst;

public class XmlExporter implements Exporter {
    @Override
    public String export(SummaryStatistics summaryStatistics) {
        String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        result += "<summaryStatistics>\n";
        result += "    <sum>" + summaryStatistics.getSum() + "</sum>\n";
        result += "    <average>" + summaryStatistics.getAverage() + "</average>\n";
        result += "    <max>" + summaryStatistics.getMax() + "</max>\n";
        result += "    <min>" + summaryStatistics.getMin() + "</min>\n";
        result += "</summaryStatistics>";
        return result;
    }


}
