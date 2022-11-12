package lotto.domain;

import java.util.Optional;

public enum Rank {
    FIRST_PLACE(6, false, 2_000_000_000),
    SECOND_PLACE(5, true, 30_000_000),
    THIRD_PLACE(5, false, 1_500_000),
    FOURTH_PLACE(4, false, 50_000),
    FIFTH_PLACE(3, false, 5_000);

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
        switch (matchCount) {
            case 6:
                return Optional.of(FIRST_PLACE);
            case 5:
                if (bonusMatch) {
                    return Optional.of(SECOND_PLACE);
                }
                return Optional.of(THIRD_PLACE);
            case 4:
                return Optional.of(FOURTH_PLACE);
            case 3:
                return Optional.of(FIFTH_PLACE);
            default:
                return Optional.empty();
        }
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
}
