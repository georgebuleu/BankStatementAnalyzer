package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzerSimple {
    private static final String RESOURCES =
            "src/main/resources/";

    public void analyze(final String filename, final BankStatementParser bankStatementParser) throws IOException {

        final Path path = Paths.get(RESOURCES + filename);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions
                = bankStatementParser.parseLinesFrom(lines);
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        System.out.println("The total for all transactions is " +
                bankStatementProcessor.calculateTotalAmount());
        System.out.println("Transaction greater than 1000 and occurred in february " +
                bankStatementProcessor.findTransaction(bankTransaction
                ->
                bankTransaction.getDate().getMonth() == Month.FEBRUARY &&
                        bankTransaction.getAmount() >= 1000));
        collectSummary(bankStatementProcessor);

    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is" +
                        bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is " +
                        bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions in February is " +
                        bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " +
                bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}







