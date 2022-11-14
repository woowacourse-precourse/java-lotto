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

public class FrontController {

    public void run() {
        MoneyController moneyController = new MoneyController(new MoneyService(new MoneyRepository()));
        int countLotto = moneyController.receiveMoney();

        LottoController lottoController = new LottoController(new LottoService(new LottoRepository()), countLotto);
        List<Lotto> lottos = lottoController.run();

        WinningNumberController winningNumberController = new WinningNumberController(new WinningNumberService(new WinningNumberRepository()));
        WinningNumber winningNumber = winningNumberController.enterNumbers();
    }
}
