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
            User user = inputMoneyWithUser();
            buyLotto(user);

            Lottos userLottos = getUserLottos(user);
            WinningLotto winningLotto = createWinningLotto();
            LottoMachine lottoMachine = new LottoMachine(winningLotto);

            Map<LottoPrize, Integer> prizeCount = getLottoPrizeResult(userLottos, lottoMachine);
            printProfitRatio(user, prizeCount);
        } catch (IllegalArgumentException e) {
            ErrorLog.printError(e.getMessage());
        }
    }

    private void printProfitRatio(User user, Map<LottoPrize, Integer> prizeCount) {
        double profitRate = LottoCalculator.getProfitRate(user, prizeCount);
        OutputView.printProfitRate(profitRate);
    }

    private Map<LottoPrize, Integer> getLottoPrizeResult(Lottos userLottos, LottoMachine lottoMachine) {
        Map<LottoPrize, Integer> prizeCount = lottoMachine.getPrizeCount(userLottos);
        OutputView.printCountOfLottoPrize(prizeCount);
        return prizeCount;
    }

    private void buyLotto(User user) {
        user.buyLotto();
        OutputView.printPurchaseCount(user.getLottoCount());
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumber = InputView.getWinningNumber();
        int bonusNumber = InputView.getBonusNumber();
        return new WinningLotto(new Lotto(winningNumber), new BonusNumber(bonusNumber));
    }

    private Lottos getUserLottos(User user) {
        Lottos userLottos = user.getLottos();
        OutputView.printLottos(userLottos);
        return userLottos;
    }

    private User inputMoneyWithUser() {
        int money = InputView.getMoney();
        return new User(money);
    }
}
