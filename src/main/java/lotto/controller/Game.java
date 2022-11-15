package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.PickedLotto;
import lotto.constant.Rank;
import lotto.domain.Seller;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.StatisticsView;
import lotto.vo.Statistics;

public class Game {

    public void play() {
        try {
            Money capital = new Money(InputView.promptAmount());
            List<Lotto> lottos = issueLottosWith(capital);

            List<Rank> ranks = pickLotto().match(lottos);

            StatisticsView.printStatistics(new Statistics(ranks), capital);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception.getMessage());
        }
    }

    private PickedLotto pickLotto() {
        Lotto winningLotto = new Lotto(InputView.promptWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(InputView.promptBonusNumber());
        return new PickedLotto(winningLotto, bonusNumber);
    }

    private List<Lotto> issueLottosWith(Money money) {
        List<Lotto> lottos = Seller.issueLottosWith(money);
        OutputView.printPurchase(lottos);
        OutputView.printIssuedLottos(lottos);
        return lottos;
    }
}
