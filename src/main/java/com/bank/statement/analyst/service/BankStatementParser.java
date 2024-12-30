package com.bank.statement.analyst.service;

import com.bank.statement.analyst.model.BankTransaction;

import java.util.List;

public interface BankStatementParser {
    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}