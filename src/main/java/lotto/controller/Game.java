package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.Picker;
import lotto.domain.Rank;
import lotto.domain.Seller;
import lotto.dto.LottoDto;
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
        List<Lotto> lottos = issueLottosWith(capital);

        List<Rank> ranks = getPicker().pick(lottos);

        Money profit = sumProfitsOf(ranks);
        double profitRate = capital.calculateProfitRateOf(profit);
    }

    private Money sumProfitsOf(List<Rank> ranks) {
        return ranks.stream()
                .map(Rank::prize)
                .reduce(Money::add)
                .orElse(new Money(0));
    }

    private Picker getPicker() {
        Lotto winningLotto = new Lotto(inputView.promptWinningNumbers());
        LottoNumber bonusNumber = new LottoNumber(inputView.promptBonusNumber());
        return new Picker(winningLotto, bonusNumber);
    }

    private List<Lotto> issueLottosWith(Money capital) {
        List<Lotto> lottos = new Seller().issueLottos(capital);
        outputView.printIssuedLottos(new LottoDto(lottos));
        return lottos;
    }
}
