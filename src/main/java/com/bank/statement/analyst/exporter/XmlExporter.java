package com.bank.statement.analyst.exporter;

import com.bank.statement.analyst.model.SummaryStatistics;

public class XmlExporter implements Exporter {
    @Override
    public String export(SummaryStatistics summaryStatistics) {
        String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        result += "<summaryStatistics>\n";
        result += "    <sum>" + summaryStatistics.sum() + "</sum>\n";
        result += "    <average>" + summaryStatistics.average() + "</average>\n";
        result += "    <max>" + summaryStatistics.max() + "</max>\n";
        result += "    <min>" + summaryStatistics.min() + "</min>\n";
        result += "</summaryStatistics>";
        return result;
    }


}
