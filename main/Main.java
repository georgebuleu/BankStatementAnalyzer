package main;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BankStatementAnalyzerSimple bankStatementAnalyzerSimple
                = new BankStatementAnalyzerSimple();
        BankStatementParser bankStatementParser = new BankStatementCSVParser();
        bankStatementAnalyzerSimple.analyze(args[0], bankStatementParser);
    }
}
