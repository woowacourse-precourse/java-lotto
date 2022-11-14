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
        int inputMoney = InputView.getUserMoney();

        LottoMachine purchasedLotto = buyLotto(inputMoney);
        User user = new User(inputMoney, purchasedLotto.getLottos());
        WinningNumber winnerNumber = getWinningNumber();

        List<Rank> ranks = getRanks(user.getLottos(), winnerNumber);

        OutputView.showGameResult(ranks, inputMoney);
    }

    public LottoMachine buyLotto(int money) {
        MoneyValidator.check(money);
        int quantity = money / LOTTO_PRICE_UNIT;

        LottoMachine purchasedLotto = new LottoMachine(quantity);
        OutputView.showLottos(purchasedLotto);
        return purchasedLotto;
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
