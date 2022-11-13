package lotto.service;

import java.util.List;
import lotto.domain.Lottery;
import lotto.domain.WinningNumbers;

public class LottoService {
    private WinningNumbers winningNumbers;
    private final Lottery lottery;

    public LottoService(int purchaseNumber) {
        this.lottery = Lottery.buy(purchaseNumber);
    }

    public void pickWinningNumbers(List<Integer> numbers, Integer bonusNumber) {
        winningNumbers = new WinningNumbers(numbers, bonusNumber);
    }

    public void calculateRank() {
        lottery.calculateRankWithWinningNumbers(winningNumbers);
    }

    public String getLotteryInfo() {
        return lottery.toStringLotteryInfo();
    }
}
