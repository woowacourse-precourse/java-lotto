package lotto;

import java.util.Arrays;

public enum Ranking {

    NOTHING(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int matchCount;
    private final int prizeMoney;

    Ranking(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Ranking findRanking(int lottoNumberMatchCount, boolean bonusNumber) {
        if (lottoNumberMatchCount == THIRD.matchCount && !bonusNumber) {
            return THIRD;
        }
        if (lottoNumberMatchCount < FIFTH.matchCount) {
            return NOTHING;
        }
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.matchCount == lottoNumberMatchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 찾을 수 없는 matchCount 입니다,"));
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}
