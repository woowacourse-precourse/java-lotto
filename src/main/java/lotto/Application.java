package lotto;

import lotto.controller.LottoController;
import lotto.domain.Judgement;
import lotto.domain.Statistics;
import lotto.view.print.MessagePrinter;
import lotto.view.scanner.NumberScanner;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new NumberScanner(),
                new MessagePrinter(),
                new Statistics(),
                new Judgement()
        );
        lottoController.start();
    }
}
