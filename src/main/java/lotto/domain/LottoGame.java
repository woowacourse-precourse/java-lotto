package lotto.domain;

import lotto.domain.strategy.CreateStrategy;

public class LottoGame {
    public static final int TicketPrice = 1_000;

    private final Lottery lottery = new Lottery();

    public void createLottery(Money money, CreateStrategy createStrategy) {
        lottery.createLottery(money.money() / TicketPrice, createStrategy);
    }

    public LottoResult lotteryResult() {
        return new LottoResult(lottery.getLottery());
    }

    public RankResult rankResult(WinningLotto winningLotto) {
        return new RankResult(lottery.RankResult(winningLotto));
    }
}
