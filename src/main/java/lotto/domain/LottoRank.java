package lotto.domain;

import java.util.stream.Stream;

public enum LottoRank {
    SIXTH(0, 0, ""),
    FIFTH(3, 5000, "3개 일치 (5,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - "),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - ");

    private final int matchCount;
    private final int reward;
    private final String message;

    LottoRank(int matchCount, int reward, String message) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.message = message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public String getMessage() {
        return message;
    }

    public static LottoRank matchRank(long count, boolean isBonus) {
        if (count < 3) {
            return SIXTH;
        }
        if (count != 5) {
            return Stream.of(LottoRank.values())
                    .filter(value -> value.matchCount == count)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
        if (isBonus) {
            return SECOND;
        }
        return THIRD;
    }
}
