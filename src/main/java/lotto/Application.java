package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.service.LottoService;
import lotto.view.input.LottoScanner;
import lotto.view.output.LottoPrinter;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService = new LottoService(
                new LottoStore(),
                new LottoMachine(),
                new LottoScanner(),
                new LottoPrinter()
        );

        lottoService.start();
    }
}
