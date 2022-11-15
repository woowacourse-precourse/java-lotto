package lotto.model.statistics;

import java.util.Arrays;

public enum LottoResult {
    MISS(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000),
    ;

    private final int matchCount;
    private final boolean doesMatchBonusBall;
    private final int prize;

    LottoResult(
            int matchCount,
            boolean doesMatchBonusBall,
            int prize
    ) {
        this.matchCount = matchCount;
        this.doesMatchBonusBall = doesMatchBonusBall;
        this.prize = prize;
    }

    public static LottoResult getLottoResult(int matchCount, boolean doesBonusMatch) {
        LottoResult[] allLottoResult = LottoResult.values();
        Arrays.sort(allLottoResult, (o1, o2) -> o1.compare(o2.matchCount, o2.doesMatchBonusBall));

        LottoResult output = LottoResult.MISS;
        for(LottoResult lottoResult : allLottoResult) {
            if(lottoResult.isOverEqualThanParams(matchCount, doesBonusMatch)) {
                break;
            }
            output = lottoResult;
        }
        return output;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean doesMatchBonusBall() {
        return doesMatchBonusBall;
    }

    public int getPrize() {
        return prize;
    }

    public int compare(int matchCount, boolean doesMatchBonusBall) {
        int matchCountCompare = Integer.compare(this.matchCount, matchCount);
        if(matchCountCompare != 0) {
            return matchCountCompare;
        }
        return Boolean.compare(this.doesMatchBonusBall, doesMatchBonusBall);
    }

    private boolean isOverEqualThanParams(int matchCount, boolean doesMatchBonusBall) {
        return compare(matchCount, doesMatchBonusBall) > 0;
    }
}
