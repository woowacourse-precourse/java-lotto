package lotto;

import java.util.stream.Stream;

import static lotto.Rank.values;

public class Calculate {
    private static final long ONE_HUNDRED = 100L;

    public static long getLotteryWinningPrize() {
        return Stream.of(values()).mapToLong(i -> i.getPrize() * i.getCount()).sum();
    }

    public static double getTotalLotteryWinningPrizeProfit(long lotteryWinningPrize, long payMoney) {
        return (double)lotteryWinningPrize / (double)payMoney * ONE_HUNDRED;
    }
}
