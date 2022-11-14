package lotto.service;

import java.util.List;
import lotto.domain.Lottery;
import lotto.domain.WinningNumbers;
import lotto.domain.Rank;

public class LottoService {
    private final Lottery lottery;
    private WinningNumbers winningNumbers;

    public LottoService(int purchaseNumber) {
        this.lottery = Lottery.buy(purchaseNumber);
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
