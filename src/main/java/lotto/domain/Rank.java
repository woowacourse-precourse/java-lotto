package lotto.domain;

import static lotto.domain.Rank.Bonus.ALL;
import static lotto.domain.Rank.Bonus.MATCH;
import static lotto.domain.Rank.Bonus.MISMATCH;

import java.util.function.Function;

/**
 * 출력하고자 하는 순서대로 상수들을 선언해주셔야 올바른 순서로 출력됩니다.
 */
public enum Rank {
    FIFTH(3, ALL, 5_000, "3개 일치"),
    FOURTH(4, ALL, 50_000, "4개 일치"),
    THIRD(5, MISMATCH, 1_500_000, "5개 일치"),
    SECOND(5, MATCH, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, ALL, 2_000_000_000, "6개 일치");

    private final int matchCount;
    private final Bonus bonusMatch;
    private final int winningPrice;
    private final String descriptionMessage;

    Rank(int matchCount, Bonus bonusMatch, int winningPrice, String descriptionMessage) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.winningPrice = winningPrice;
        this.descriptionMessage = descriptionMessage;
    }

    public static Rank getRank(int matchCount, boolean bonusMatch) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && rank.bonusMatch.isMatch(bonusMatch)) {
                return rank;
            }
        }
        return null;
    }

    public String getDescriptionMessage() {
        return this.descriptionMessage;
    }

    public int getWinningPrice() {
        return this.winningPrice;
    }

    enum Bonus {
        MATCH(bonusMatch -> bonusMatch == true),
        MISMATCH(bonusMatch -> bonusMatch == false),
        ALL(bonusMatch -> true);

        private final Function<Boolean, Boolean> matchFunction;

        Bonus(Function<Boolean, Boolean> matchFunction) {
            this.matchFunction = matchFunction;
        }

        boolean isMatch(boolean bonusMatch) {
            return this.matchFunction.apply(bonusMatch);
        }
    }
}
