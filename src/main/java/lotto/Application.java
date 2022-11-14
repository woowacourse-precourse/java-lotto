package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.domain.WinningNumberParser;
import lotto.service.LottoService;
import lotto.view.input.LottoScanner;
import lotto.view.output.LottoPrinter;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService(
                new LottoStore(),
                new LottoMachine(new WinningNumberParser()));

        LottoGame lottoGame = new LottoGame(
                lottoService,
                new LottoScanner(),
                new LottoPrinter());

        lottoGame.start();
    }
}
