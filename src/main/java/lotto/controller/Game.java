package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.Picker;
import lotto.domain.Rank;
import lotto.domain.Seller;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {

    private final InputView inputView;
    private final OutputView outputView;

    public Game(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Money capital = new Money(inputView.promptAmount());
        List<Lotto> lottos = new Seller().issueLottos(capital);

        Lotto winningLotto = new Lotto(inputView.promptWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(inputView.promptBonusNumber());
        List<Rank> ranks = new Picker(winningLotto, bonusNumber).pick(lottos);

        Money profit = new Money(0);
        for (Rank rank : ranks) {
            profit = profit.add(rank.prize());
        }

        capital.calculateProfitRateOf(profit);
    }
}
