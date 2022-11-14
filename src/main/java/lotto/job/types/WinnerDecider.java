package lotto.job.types;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.job.Job;
import lotto.printer.Printer;
import lotto.printer.PrinterText;
import lotto.publisher.Lotto;
import lotto.publisher.WinnerLotto;
import lotto.reader.Reader;

public class WinnerDecider implements Job {

    private final Printer printer;
    private final Reader reader;

    public WinnerDecider(Printer printer, Reader reader) {
        this.printer = printer;
        this.reader = reader;
    }

    @Override
    public void doJob() {
        printer.print(PrinterText.REQUEST_WINNER_NUMBER);
        String numbersWithDot = reader.read();

        Lotto winningLotto = new Lotto(Arrays.stream(numbersWithDot.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        WinnerLotto.getInstance().setWinnerLotto(winningLotto);

    }
}
