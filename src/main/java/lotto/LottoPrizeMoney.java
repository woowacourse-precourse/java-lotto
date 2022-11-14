package lotto;

public class LottoPrizeMoney {
    public long lottoPrizeMoney(int lotto1Win, int lotto2Win, int lotto3Win, int lotto4Win, int lotto5Win) {
        long totalLottoPrizeMoney = 0;
        totalLottoPrizeMoney += (lotto1Win * 2_000_000_000L);
        totalLottoPrizeMoney += (lotto2Win * 30_000_000L);
        totalLottoPrizeMoney += (lotto3Win * 1_500_000L);
        totalLottoPrizeMoney += (lotto4Win * 50_000L);
        totalLottoPrizeMoney += (lotto5Win * 5_000L);
        return totalLottoPrizeMoney;
    }

}
