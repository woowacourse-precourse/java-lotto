package lotto.domain.raffleDevice;

import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class RaffleResultCalculator {

    public double getProfitRate(Map<Rank, Integer> lottoResult, int lottosSize) {
        int totalWinningMoney = 0;
        int totalLottoBuyMoney = lottosSize * 1000;

        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            totalWinningMoney += lottoResult.get(rank) * rank.getRewardInt();
        }

        return ((double) totalWinningMoney / (double) totalLottoBuyMoney)  * 100.0;
    }
}
