package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public void run() {
        long inputMoney = InputView.getUserMoney();
        User user = new User(inputMoney, buyLotto(inputMoney));
        OutputView.showPurchasedLotto(user);

        WinningNumber winnerNumber = getWinningNumber();
        List<Rank> ranks = getRanks(user, winnerNumber);

        OutputView.showGameResult(user, ranks);
    }

    public List<Lotto> buyLotto(long money) {
        return LottoMachine.order(money);
    }

    public WinningNumber getWinningNumber() {
        Lotto lotto = new Lotto(InputView.getWinningNumber());
        int bonusNumber = InputView.getBonusNumber();

        return new WinningNumber(lotto, bonusNumber);
    }

    public List<Rank> getRanks(User user, WinningNumber winningNumber) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lotto : user.getLottos()) {
            Rank rank = Rank.calculate(lotto, winningNumber);
            ranks.add(rank);
        }
        return ranks;
    }
}
