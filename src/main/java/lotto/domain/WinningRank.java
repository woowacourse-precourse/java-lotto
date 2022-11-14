package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public enum WinningRank {
    SIX_MATCH(6, false, 2000000000),
    FIVE_MATCH_BONUS(5, false, 30000000),
    FIVE_MATCH(5, false, 1500000),
    FOUR_MATCH(4, false, 50000),
    THREE_MATCH(3, false, 5000);

    private final int matchingCount;
    private final boolean containsBonusNumber;
    private final int winningAmount;

    WinningRank(int matchingCount, boolean containsBonusNumber, int winningPrice) {
        this.matchingCount = matchingCount;
        this.containsBonusNumber = containsBonusNumber;
        this.winningAmount = winningPrice;
    }

    public static Map<WinningRank, Integer> getWinningDetails() {
        Map<WinningRank, Integer> winningDetails = new EnumMap<>(WinningRank.class);
        Arrays.stream(values()).forEach(winningRank -> winningDetails.put(winningRank, 0));
        return winningDetails;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean getContainsBonusNumber() {
        return containsBonusNumber;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}