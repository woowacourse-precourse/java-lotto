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
    
    MoneyController money;
    WinningController winning;
    LottoController lotto;
    ResultController result;

    Mission() {
        money = new MoneyController();
        winning = new WinningController();
        lotto = new LottoController();

        try {
            play();
        } catch (IllegalArgumentException e) {
            Output.printErrorAndExit(e.getMessage());
        }
    }

    private void play() {
        Money money = this.money.getMoney();

        List<Lotto> lottos = lotto.getLottos(money);

        WinningLotto winningLotto = winning.getWinningLotto();

        result = new ResultController(winningLotto, lottos);
        result.sratchLottos();
        result.printResult();
        result.printRate(money);
    }
}
