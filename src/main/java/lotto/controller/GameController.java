package lotto.controller;

import lotto.domain.*;
import lotto.validator.MoneyValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.Const.*;

public class GameController {

    public void run() {
        long inputMoney = InputView.getUserMoney();
        User user = new User(inputMoney, buyLotto(inputMoney));
        OutputView.showPurchasedLotto(user);

        WinningNumber winnerNumber = getWinningNumber();
        List<Rank> ranks = getRanks(user.getLottos(), winnerNumber);

        OutputView.showGameResult(ranks, inputMoney);
    }

    public List<Lotto> buyLotto(long money) {
        MoneyValidator.check(money);
        long quantity = money / LOTTO_PRICE_UNIT;

        return LottoMachine.order(quantity);
    }

    public WinningNumber getWinningNumber() {
        Lotto lotto = new Lotto(InputView.getWinningNumber());
        int bonusNumber = InputView.getBonusNumber();

        return new WinningNumber(lotto, bonusNumber);
    }

    public List<Rank> getRanks(List<Lotto> lottos, WinningNumber winningNumber) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lotto : lottos) {
            Rank rank = Rank.calculate(lotto, winningNumber);
            ranks.add(rank);
        }
        return ranks;
    }
}
