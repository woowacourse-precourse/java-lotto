package lotto.domain.raffleDevice;

import lotto.domain.Rank;

import java.util.List;

public class RaffleResultCalculator {

    public double calculateStatics(List<Integer> lottoResult, int lottosSize) {
        int totalWinningMoney = 0;
        int totalLottoBuyMoney = lottosSize * 1000;

        List<Integer> winningMoney = List.of(
                0,
                Rank.FIRST.getRewardInt(),
                Rank.SECOND.getRewardInt(),
                Rank.THIRD.getRewardInt(),
                Rank.FOURTH.getRewardInt(),
                Rank.FIFTH.getRewardInt());

        for (int i = 1; i <= 5; i++) {
            totalWinningMoney += (winningMoney.get(i) * lottoResult.get(i));
        }

        return ((double) totalWinningMoney / (double) totalLottoBuyMoney)  * 100.0;
    }
}
