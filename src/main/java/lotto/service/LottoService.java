package lotto.service;

import java.util.List;
import lotto.domain.Lottery;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.domain.Rank;

public class LottoService {
    private final Lottery lottery;
    private final PurchaseAmount purchaseAmount;
    private WinningNumbers winningNumbers;

    public LottoService(int money) {
        this.purchaseAmount = new PurchaseAmount(money);
        this.lottery = Lottery.buy(purchaseAmount);
    }

    public void pickWinningNumbers(List<Integer> numbers, Integer bonusNumber) {
        winningNumbers = new WinningNumbers(numbers, bonusNumber);
    }

    public void calculateRank() {
        Rank.clearCount();
        lottery.calculateRankWithWinningNumbers(winningNumbers);
    }

    public String getLotteryInfo() {
        return lottery.toStringLotteryInfo();
    }
}
