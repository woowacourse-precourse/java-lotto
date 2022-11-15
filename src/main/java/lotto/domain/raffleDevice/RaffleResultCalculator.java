package lotto.domain.raffleDevice;

import lotto.domain.Rank;

import java.util.Map;

public class RaffleResultCalculator {

    private final int LOTTO_PRICE = 1000;
    private static final double PERCENTAGE_CORRECTION = 100.0;

    public double getProfitRate(Map<Rank, Integer> lottoResult, int lottosSize) {
        int totalWinningMoney = 0;
        int totalLottoBuyMoney = lottosSize * LOTTO_PRICE;

        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            totalWinningMoney += lottoResult.get(rank) * rank.getRewardInt();
        }

        return ((double) totalWinningMoney / (double) totalLottoBuyMoney) * PERCENTAGE_CORRECTION;
    }
}
