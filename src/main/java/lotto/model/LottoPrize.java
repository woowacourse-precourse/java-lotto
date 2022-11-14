package lotto.model;

import java.util.HashMap;
import java.util.Map;

public enum LottoPrize {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    NO_PRIZE(0);

    private static final Map<CompareResult, LottoPrize> compareResultToPrize = new HashMap<>();
    private final int money;

    static {
        compareResultToPrize.put(new CompareResult(6, false), FIRST);
        compareResultToPrize.put(new CompareResult(5, true), SECOND);
        compareResultToPrize.put(new CompareResult(5, false), THIRD);
        compareResultToPrize.put(new CompareResult(4, true), FOURTH);
        compareResultToPrize.put(new CompareResult(4, false), FOURTH);
        compareResultToPrize.put(new CompareResult(3, true), FIFTH);
        compareResultToPrize.put(new CompareResult(3, false), FIFTH);
    }

    private LottoPrize(int money) {
        this.money = money;
    }

    public static LottoPrize toPrize(CompareResult lottoResult) {
        return compareResultToPrize.getOrDefault(lottoResult, NO_PRIZE);
    }

    public int getMoney() {
        return money;
    }
}
