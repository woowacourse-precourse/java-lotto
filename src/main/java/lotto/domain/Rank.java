package lotto.domain;

import java.util.Arrays;
import java.util.Optional;
import lotto.dto.RankDto;

public enum Rank implements RankDto {
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
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.checkRank(rank, matchCount, bonusMatch))
                .findFirst();
    }

    public static boolean checkRank(Rank rank, int matchCount, boolean bonusMatch) {
        if (matchCount != rank.matchCount) {
            return false;
        }
        if (matchCount == SECOND_PLACE.matchCount) {
            return rank.bonusMatch == bonusMatch;
        }
        return true;
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public void plusCount() {
        this.count += 1;
    }

    public int getTotalPrize() {
        return prize * count;
    }

    public static void clearCount() {
        FIRST_PLACE.count = 0;
        SECOND_PLACE.count = 0;
        THIRD_PLACE.count = 0;
        FOURTH_PLACE.count = 0;
        FIFTH_PLACE.count = 0;
    }
}
