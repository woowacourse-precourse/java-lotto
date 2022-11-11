package lotto.model;

import java.util.HashMap;
import java.util.Map;

public enum Prize {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    NO_PRIZE(0);

    private static final Map<CompareResult, Prize> compareResultToPrize = new HashMap<>();
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

    private Prize(int money) {
        this.money = money;
    }
    public static Prize toPrize(CompareResult lottoResult) {
        return compareResultToPrize.getOrDefault(lottoResult, NO_PRIZE);
    }

    public int getMoney() {
        return money;
    }
}
