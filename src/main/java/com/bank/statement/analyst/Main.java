package com.bank.statement.analyst;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
            final BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
            final BankStatementCSVParser csvParser = new BankStatementCSVParser();

            analyzer.analyze("bank-data.csv", csvParser);

    }
}