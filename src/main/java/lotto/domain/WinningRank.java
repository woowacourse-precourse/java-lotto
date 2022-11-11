package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public enum WinningRank {
    FIRST_PLACE(6, false, 2_000_000_000),
    SECOND_PLACE(5, true, 30_000_000),
    THIRD_PLACE(5, false, 1_500_000),
    FOURTH_PLACE(4, false, 50_000),
    FIFTH_PLACE(3, false, 5_000);

    private static final int INITIAL_VALUE = 0;

    private final int matchingCount;
    private final boolean containsBonusNumber;
    private final int winningPrice;

    WinningRank(int matchingCount, boolean containsBonusNumber, int winningPrice) {
        this.matchingCount = matchingCount;
        this.containsBonusNumber = containsBonusNumber;
        this.winningPrice = winningPrice;
    }

    public static Map<WinningRank, Integer> getWinningDetails() {
        Map<WinningRank, Integer> winningDetails = new EnumMap<>(WinningRank.class);
        Arrays.stream(values()).forEach(winningRank -> winningDetails.put(winningRank, INITIAL_VALUE));
        return winningDetails;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean getContainsBonusNumber() {
        return containsBonusNumber;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
