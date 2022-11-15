package lotto.domain;

import lotto.view.OutputView;

public class LottoGame {
    private final Money money;
    private final WinningLotto winningLotto;
    private final BonusNumber bonusNumber;

    public LottoGame(Money money, WinningLotto winningLotto, BonusNumber bonusNumber) {
        this.money = money;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Lottos generateLottos(LottoQuantity lottoQuantity) {
        LottoGenerator lottoGenerator = new LottoGenerator(lottoQuantity);
        return lottoGenerator.generate();
    }

    public LottoQuantity generateQuantity() {
        return new LottoQuantity(money);
    }

    public LottoResults generateLottoResult(Lottos lottos) {
        LottoComparator lottoComparator = new LottoComparator(lottos, winningLotto, bonusNumber);
        return lottoComparator.compare();
    }

    public RateOfReturn generateRateOfReturn(LottoResults lottoResults) {
        return new RateOfReturn(lottoResults, money);
    }
}
