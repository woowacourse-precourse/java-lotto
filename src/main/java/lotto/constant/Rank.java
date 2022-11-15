package lotto.constant;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private int winningBallMatchCount;
    private boolean isBonusBallMustMatch;
    private int money;

    Rank(int winningBallMatchCount, boolean isBonusBallMustMatch, int money) {
        this.winningBallMatchCount = winningBallMatchCount;
        this.isBonusBallMustMatch = isBonusBallMustMatch;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public static Rank getRank(int winningBallMatchCount, boolean isBonusBallMatch) {
        Optional<Rank> rank = Arrays.stream(values())
                .filter(r -> r.winningBallMatchCount == winningBallMatchCount && verifyBonusBall(
                        r.isBonusBallMustMatch, isBonusBallMatch))
                .findAny();
        if (rank.isEmpty()) {
            return NONE;
        }
        return rank.get();
    }

    private static boolean verifyBonusBall(boolean isBonusBallMustMatch, boolean isBonusBallMatch) {
        if (isBonusBallMustMatch) {
            return isBonusBallMatch;
        }
        return true;
    }
}
