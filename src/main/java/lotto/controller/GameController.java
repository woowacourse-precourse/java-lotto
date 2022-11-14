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

        LottoMachine lottos = buyLotto(inputMoney);
        User user = new User(inputMoney, lottos.getLottos());
        WinningNumber winnerNumber = getWinningNumber();

        List<Rank> ranks = getRanks(user.getLottos(), winnerNumber);
    }

    public LottoMachine buyLotto(int money) {
        MoneyValidator.check(money);
        int count = money / LOTTO_PRICE_UNIT;

        LottoMachine lottos = new LottoMachine(count);
        OutputView.showLottos(lottos);
        return lottos;
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
