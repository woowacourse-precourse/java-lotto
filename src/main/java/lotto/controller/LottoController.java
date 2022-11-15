package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        int amountOfMoney = InputView.readAmountOfMoney();
        User user = new User(amountOfMoney);

        OutputView.printLottos(user.getLottos());

        WinningLotto winningLotto = readWinningLotto();

        Map<Ranking, Integer> numberOfRankedLottos = user.checkResult(winningLotto);
        double yield = user.calculateYield();
        OutputView.printResult(numberOfRankedLottos, yield);
    }

    private static WinningLotto readWinningLotto() {
        List<Integer> numbers = InputView.readWinningNumbers();
        Lotto lotto = new Lotto(numbers);
        int bonus = InputView.readBonusNumber();

        return new WinningLotto(lotto, bonus);
    }
}
