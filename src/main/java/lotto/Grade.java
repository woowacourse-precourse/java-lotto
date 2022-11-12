package lotto;

import java.util.Arrays;

public enum Grade {
    FIVE(3, 5_000),
    FOUR(4, 50_000),
    THREE(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int prizeMoney;

    Grade(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Grade findingRank(int matchCount, int bonusCount) {
        if ((THREE.matchCount == matchCount) && (bonusCount == 0)) {
            return THREE;
        }
        if ((SECOND.matchCount == matchCount) && (bonusCount == 1)) {
            return SECOND;
        }

        return Arrays.stream(values()).filter(grade -> grade.matchCount == matchCount)
                .findAny().orElseThrow(() -> new IllegalArgumentException("[ERROR] 미당첨입니다."));
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
