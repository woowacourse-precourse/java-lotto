package lotto.job.types;

import java.util.ArrayList;
import java.util.List;
import lotto.job.Job;
import lotto.printer.Printer;
import lotto.printer.PrinterFormat;
import lotto.printer.PrinterText;
import lotto.publisher.Lotto;
import lotto.publisher.LottoPublisher;
import lotto.reader.Reader;

public class LottoSeller implements Job {


    private final Printer printer;
    private final Reader reader;

    public LottoSeller(Printer printer, Reader reader) {
        this.printer = printer;
        this.reader = reader;
    }

    public List<Lotto> sellLotto(int cash) {
        LottoPublisher lottoPublisher = new LottoPublisher();
        List<Lotto> lottos = new ArrayList<>();

        int lottoCount = cash / 1000;

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(lottoPublisher.publishLotto());
        }

        return lottos;
    }

    @Override
    public void doJob() {
        printer.print(PrinterText.REQUEST_BUY_CASH_UNIT);
        int cash = Integer.parseInt(reader.read());
        printer.print(PrinterFormat.BOUGHT_LOTTO_COUNT, cash / 1000);

        List<Lotto> lottos = sellLotto(cash);

        for (Lotto i : lottos) {
            printer.print(PrinterFormat.BOUGHT_LOTTO_NUMBERS, i.getNumbers().toArray());
        }

    }
}
