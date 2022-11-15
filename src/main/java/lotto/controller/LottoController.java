package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoMachine;
import lotto.domain.LottoPrize;
import lotto.domain.Lottos;
import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.view.ErrorLog;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        try {
            int money = InputView.getMoney();
            User user = new User(money);
            user.buyLotto();

            OutputView.printPurchaseCount(user.getLottoCount());
            Lottos userLottos = user.getLottos();
            OutputView.printLottos(userLottos);

            List<Integer> winningNumber = InputView.getWinningNumber();
            int bonusNumber = InputView.getBonusNumber();

            WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumber), new BonusNumber(bonusNumber));
            LottoMachine lottoMachine = new LottoMachine(winningLotto);

            List<LottoPrize> prizeResult = lottoMachine.getPrizeResult(userLottos);

            double profitRate = LottoCalculator.getProfitRate(user, prizeResult);
            Map<LottoPrize, Integer> prizeCount = lottoMachine.getPrizeCount(userLottos);

            OutputView.printCountOfLottoPrize(prizeCount);
            OutputView.printProfitRate(profitRate);
        } catch (IllegalArgumentException e) {
            ErrorLog.printError(e.getMessage());
        }
    }
}
