package lotto.job.types;

import lotto.job.Job;
import lotto.printer.Printer;
import lotto.printer.PrinterText;
import lotto.publisher.WinnerLotto;
import lotto.reader.Reader;

public class BonusDecider implements Job {

    private final Printer printer;
    private final Reader reader;

    public BonusDecider(Printer printer, Reader reader) {
        this.printer = printer;
        this.reader = reader;
    }

    @Override
    public void doJob() {
        printer.print(PrinterText.REQUEST_BONUS_NUMBER);
        String bonusNumber = reader.read();

        WinnerLotto.getInstance().setBonusNumber(Integer.parseInt(bonusNumber));

    }
}
