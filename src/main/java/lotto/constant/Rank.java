package lotto.constant;

import java.util.Arrays;
import java.util.Optional;
import lotto.WinningMoney;

public enum Rank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000) {
        public String getMessage(int count) {
            return String.format("%d개 일치 (%s), 보너스 볼 일치 - %d개", THIRD.winningBallMatchCount,
                    THIRD.winningMoney.toString(),
                    count);
        }
    },
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private int winningBallMatchCount;
    private boolean isBonusBallMustMatch;
    private WinningMoney winningMoney;

    Rank(int winningBallMatchCount, boolean isBonusBallMustMatch, int winningMoney) {
        this.winningBallMatchCount = winningBallMatchCount;
        this.isBonusBallMustMatch = isBonusBallMustMatch;
        this.winningMoney = new WinningMoney(winningMoney);
    }

    public WinningMoney getWinningMoney() {
        return winningMoney;
    }

    public String getMessage(int count) {
        return String.format("%d개 일치 (%s) - %d개", this.winningBallMatchCount,
                winningMoney.toString(),
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
