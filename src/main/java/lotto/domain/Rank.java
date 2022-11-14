package lotto.domain;

import java.util.Optional;

public enum Rank {
    FIFTH_PLACE(3, false, 5_000),
    FOURTH_PLACE(4, false, 50_000),
    THIRD_PLACE(5, false, 1_500_000),
    SECOND_PLACE(5, true, 30_000_000),
    FIRST_PLACE(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;
    private int count;

    Rank(int matchCount, boolean bonusMatch, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public static Optional<Rank> matchRank(int matchCount, boolean bonusMatch) {
        Rank[] ranksNotRelatedToBonusNumber = {FIRST_PLACE, THIRD_PLACE, FOURTH_PLACE, FIFTH_PLACE};
        if (matchCount == SECOND_PLACE.matchCount && bonusMatch) {
            return Optional.of(SECOND_PLACE);
        }
        for (Rank rank : ranksNotRelatedToBonusNumber) {
            if (matchCount == rank.matchCount) {
                return Optional.of(rank);
            }
        }
        return Optional.empty();
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public void plusCount() {
        this.count += 1;
    }

    public static void clearCount() {
        FIRST_PLACE.count = 0;
        SECOND_PLACE.count = 0;
        THIRD_PLACE.count = 0;
        FOURTH_PLACE.count = 0;
        FIFTH_PLACE.count = 0;
    }
}
