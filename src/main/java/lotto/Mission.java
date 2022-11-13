package lotto;

import java.util.List;
import lotto.controller.LottoController;
import lotto.controller.MoneyController;
import lotto.controller.ResultController;
import lotto.controller.WinningController;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.Output;

public class Mission {
    
    MoneyController moneyController;
    WinningController winningController;
    LottoController lottoController;
    ResultController resultController;

    Mission() {
        moneyController = new MoneyController();
        winningController = new WinningController();
        lottoController = new LottoController();

        try {
            play();
        } catch (IllegalArgumentException e) {
            Output.printErrorAndExit(e.getMessage());
        }
    }

    private void play() {
        Money money = moneyController.getMoney();

        List<Lotto> lottos = lottoController.getLottos(money);

        WinningLotto winningLotto = winningController.getWinningLotto();

        resultController = new ResultController(winningLotto, lottos);
        resultController.sratchLottos();
        resultController.printResult();
        resultController.printRate(money);
    }
}
