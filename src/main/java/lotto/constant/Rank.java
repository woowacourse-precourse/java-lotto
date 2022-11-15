package lotto.constant;

import static lotto.constant.Message.MATCH;
import static lotto.constant.Message.MATCH_NO_BONUS;

import java.util.Arrays;
import java.util.Optional;
import lotto.Money;

public enum Rank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000) {
        public String getMessage(int count) {
            return String.format(MATCH_NO_BONUS, THIRD.winningBallMatchCount,
                    THIRD.money.toString(),
                    count);
        }
    },
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private int winningBallMatchCount;
    private boolean isBonusBallMustMatch;
    private Money money;

    Rank(int winningBallMatchCount, boolean isBonusBallMustMatch, int money) {
        this.winningBallMatchCount = winningBallMatchCount;
        this.isBonusBallMustMatch = isBonusBallMustMatch;
        this.money = new Money(money);
    }

    public Money getMoney() {
        return money;
    }

    public String getMessage(int count) {
        return String.format(MATCH, this.winningBallMatchCount,
                money.toString(),
                count);
    }

    public static Rank getRank(int winningBallMatchCount, boolean isBonusBallMatch) {
        Optional<Rank> rank = Arrays.stream(values())
                .filter(r -> r.winningBallMatchCount == winningBallMatchCount
                        && verifyBonusBall(r.isBonusBallMustMatch, isBonusBallMatch))
                .findFirst();
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
