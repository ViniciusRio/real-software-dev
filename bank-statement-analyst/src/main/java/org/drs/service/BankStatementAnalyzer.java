package org.drs.service;

import org.drs.util.BankSummary;
import org.drs.model.BankTransaction;
import org.drs.model.SummaryStatistics;
import org.drs.exporter.Exporter;
import org.drs.exporter.HtmlExporter;
import org.drs.exporter.JsonExporter;
import org.drs.exporter.XmlExporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public void analyze(final String fileName, final BankStatementParser parser) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bancoTransactions = parser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bancoTransactions);

        collectSummary(bankStatementProcessor);


    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transaction is " + bankStatementProcessor.calculateTotalAmount());
        BankSummary transactionJanuary = bankStatementProcessor.calculateTotalInMonth(Month.JANUARY);
        System.out.println("Transactions in January " + transactionJanuary.getTotal());
        BankSummary transactionFebruary = bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY);
        System.out.println("Transactions in February " + transactionFebruary.getTotal());
        System.out.println("The total of salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));

        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 1, 15);
        System.out.println("The max debit between " +
                startDate +
                " e " +
                endDate +
                ": " +
                bankStatementProcessor.calculateMaxAmountNegativeBetweenDates(startDate, endDate));

        SummaryStatistics summaryStatistics = new SummaryStatistics(
                1780,
                1200,
                -300,
                178.0
        );

        Exporter htmlExporter = new HtmlExporter();
        Exporter xmlExporter = new XmlExporter();
        Exporter jsonExporter = new JsonExporter();
        String htmlOutput = htmlExporter.export(summaryStatistics);
        String xmlOutput = xmlExporter.export(summaryStatistics);
        String jsonOutput = jsonExporter.export(summaryStatistics);

        System.out.println("HTML: " + htmlOutput);
        System.out.println("XML: " + xmlOutput);
        System.out.println("JSON: " + jsonOutput);
    }
}
