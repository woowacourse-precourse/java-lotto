package lotto;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

public enum LotteryRank {
    SIXTH_PLACE(0, 0),
    FIFTH_PLACE(3, 5000),
    FOURTH_PLACE(4, 50000),
    THIRD_PLACE(5, 1500000),
    SECOND_PLACE(5, 30000000),
    FIRST_PLACE(6, 2000000000);

    private int matches;
    private int reward;

    LotteryRank(int matches, int reward) {
        this.matches = matches;
        this.reward = reward;
    }

    public int getMatches() {
        return matches;
    }

    public int getReward() {
        return reward;
    }

    public static LotteryRank getRank(int theNumberOfMatch, boolean containsBonusNumber) {
        if ( (theNumberOfMatch == 5) && containsBonusNumber ) {
            return SECOND_PLACE;
        }

        if ( theNumberOfMatch < FIFTH_PLACE.matches ) {
            return SIXTH_PLACE;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.matches == theNumberOfMatch)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
