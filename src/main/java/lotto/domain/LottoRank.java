package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    NONE(0, 0);

    private final int money;
    private final int matchedCount;
    private final String matchedPhrase = "개 일치";
    private final String matchedBonusPhrase = "보너스 볼 일치";

    LottoRank(int money, int matchedCount) {
        this.money = money;
        this.matchedCount = matchedCount;
    }

    public int getMoney() {
        return money;
    }

    public static LottoRank checkRanking(int matchCount, boolean isBonus) {
        if (matchCount == SECOND.matchedCount && isBonus) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(r -> r.matchedCount == matchCount && r != SECOND)
                .findFirst()
                .orElse(LottoRank.NONE);
    }

    @Override
    public String toString() {
        if (this == SECOND) {
            return matchedCount + matchedPhrase + "," + matchedBonusPhrase + " (" + money + "원)";
        }
        return matchedCount + matchedPhrase + " (" + money + "원)";
    }
}