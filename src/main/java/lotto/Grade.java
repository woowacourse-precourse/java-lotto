package lotto;

import java.util.Arrays;

public enum Grade {
    FIVE(3, 5_000, 5),
    FOUR(4, 50_000, 4),
    THREE(5, 1_500_000, 3),
    SECOND(5, 30_000_000, 2),
    FIRST(6, 2_000_000_000, 1);

    private final int matchCount;
    private final int prizeMoney;
    private final int ranking;

    Grade(int matchCount, int prizeMoney, int ranking) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.ranking = ranking;
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

    public int getRanking() {
        return ranking;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
