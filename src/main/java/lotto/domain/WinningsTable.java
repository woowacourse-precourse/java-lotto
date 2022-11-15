package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum WinningsTable {
    FIRST(List.of(6, 0), "2,000,000,000"),
    SECOND(List.of(5, 1), "30,000,000"),
    THIRD(List.of(5, 0), "1,500,000"),
    FOURTH(List.of(4, 0), "50,000"),
    FIFTH(List.of(3, 0), "5,000"),
    NOTHING(Collections.EMPTY_LIST, "0");

    private static final int RAFFLE_MATCHES = 0;

    private final List<Integer> NUMBER_OF_MATCHES;
    private final String REVENUE;

    WinningsTable(List<Integer> numberOfMatches, String revenue) {
        this.REVENUE = revenue;
        this.NUMBER_OF_MATCHES = numberOfMatches;
    }

    public static boolean isSame(WinningsTable winningsTable, String rankName) {
        return rankName.equals(winningsTable.name());
    }

    public static WinningsTable findByMatches(String rankName) {

        return Arrays.stream(WinningsTable.values()).
                filter(winningsTable -> WinningsTable.isSame(winningsTable, rankName)).
                findAny().
                orElse(NOTHING);
    }

    public static String getWinningsByMatchState(String rankName) {
        WinningsTable winningsTable = WinningsTable.findByMatches(rankName);
        return winningsTable.REVENUE;
    }

    public static int getRaffleMatchesByMatchState(String rankName) {
        WinningsTable winningsTable = WinningsTable.findByMatches(rankName);
        return winningsTable.NUMBER_OF_MATCHES.get(RAFFLE_MATCHES);
    }

}
