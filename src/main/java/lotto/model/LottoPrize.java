package lotto.model;

import java.util.HashMap;
import java.util.Map;

public enum LottoPrize {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    LOSE(0);

    private static final Map<CompareResult, LottoPrize> compareResultToLottoPrize = new HashMap<>();
    private final int winningAmount;

    static {
        compareResultToLottoPrize.put(new CompareResult(6, false), FIRST);
        compareResultToLottoPrize.put(new CompareResult(5, true), SECOND);
        compareResultToLottoPrize.put(new CompareResult(5, false), THIRD);
        compareResultToLottoPrize.put(new CompareResult(4, true), FOURTH);
        compareResultToLottoPrize.put(new CompareResult(4, false), FOURTH);
        compareResultToLottoPrize.put(new CompareResult(3, true), FIFTH);
        compareResultToLottoPrize.put(new CompareResult(3, false), FIFTH);
    }

    private LottoPrize(int winningAmount) {
        this.winningAmount = winningAmount;
    }

    public static LottoPrize toPrize(CompareResult lottoResult) {
        return compareResultToLottoPrize.getOrDefault(lottoResult, LOSE);
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
