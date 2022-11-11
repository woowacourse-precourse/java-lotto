package lotto.model;

import java.util.HashMap;
import java.util.Map;

public enum Prize {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FIFTH,
    NO_PRIZE;

    private static final Map<CompareResult, Prize> compareResultToPrize = new HashMap<>();

    static {
        compareResultToPrize.put(new CompareResult(6, false), FIRST);
        compareResultToPrize.put(new CompareResult(5, true), SECOND);
        compareResultToPrize.put(new CompareResult(5, false), THIRD);
        compareResultToPrize.put(new CompareResult(4, true), FOURTH);
        compareResultToPrize.put(new CompareResult(4, false), FOURTH);
        compareResultToPrize.put(new CompareResult(3, true), FIFTH);
        compareResultToPrize.put(new CompareResult(3, false), FIFTH);
    }
    public static Prize toPrize(CompareResult lottoResult) {
        return compareResultToPrize.getOrDefault(lottoResult, NO_PRIZE);
    }
}
