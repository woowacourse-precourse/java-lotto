package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.repository.LottoRepository;
import lotto.repository.MoneyRepository;
import lotto.repository.WinningNumberRepository;
import lotto.service.LottoService;
import lotto.service.MoneyService;
import lotto.service.WinningNumberService;
import view.ExceptionView;

public class FrontController {

    public void run() {
        try {
            int countLotto = runMoneyController();
            List<Lotto> lottos = runLottoController(countLotto);
            WinningNumber winningNumber = runWinningNumberController();
            runPrizeController(lottos, winningNumber, countLotto);
        } catch (IllegalArgumentException e) {
            ExceptionView exceptionView = new ExceptionView(e.getMessage());
            exceptionView.show();
            return;
        }
    }

    private int runMoneyController() {
        MoneyController moneyController = new MoneyController(new MoneyService(new MoneyRepository()));
        return moneyController.receiveMoney();
    }

    private List<Lotto> runLottoController(int countLotto) {
        LottoController lottoController = new LottoController(new LottoService(new LottoRepository()), countLotto);
        return lottoController.run();
    }

    private WinningNumber runWinningNumberController() {
        WinningNumberController winningNumberController = new WinningNumberController(
                new WinningNumberService(new WinningNumberRepository()));
        return winningNumberController.enterNumbers();
    }

    private void runPrizeController(List<Lotto> lottos, WinningNumber winningNumber, int countLotto) {
        PrizeController prizeController = new PrizeController(lottos, winningNumber, countLotto);
        prizeController.run();
    }
}
