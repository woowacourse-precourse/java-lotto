package lotto.domain;

import java.util.ArrayList;
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
    private final String revenue;

    WinningsTable(List<Integer> numberOfMatches, String revenue) {
        this.revenue = revenue;
        this.NUMBER_OF_MATCHES = numberOfMatches;
    }

    public static boolean isSameRankName(WinningsTable winningsTable, String rankName) {
        return rankName.equals(winningsTable.name());
    }
    public static boolean isSameMatches(WinningsTable winningsTable, List<Integer> matches) {
        return Arrays.equals(winningsTable.NUMBER_OF_MATCHES.toArray(), matches.toArray());
    }
    public static WinningsTable findByRankName(String rankName) {

        return Arrays.stream(WinningsTable.values()).
                filter(winningsTable -> WinningsTable.isSameRankName(winningsTable, rankName)).
                findAny().
                orElse(NOTHING);
    }
    public static WinningsTable findByMatches(List<Integer> matches) {

        return Arrays.stream(WinningsTable.values()).
                filter(winningsTable -> WinningsTable.isSameMatches(winningsTable, matches)).
                findAny().
                orElse(NOTHING);
    }
    public static List<String> getRankNames() {
        List<String> rankName = new ArrayList<>();
        for (WinningsTable winningsTable : WinningsTable.values()) {
            if (!winningsTable.name().equals("NOTHING")) {
                rankName.add(winningsTable.name());
            }
        }
        return rankName;
    }
    public static String getRankNameByMatchState(List<Integer> match) {
        WinningsTable winningsTable = WinningsTable.findByMatches(match);
        return winningsTable.name();
    }
    public static String getWinningsByMatchState(String rankName) {
        WinningsTable winningsTable = WinningsTable.findByRankName(rankName);
        return winningsTable.revenue;
    }
    public static int transform(String revenue){
        List<String> separatedRevenue=List.of(revenue.split(","));
        String combinedRevenue=String.join("",separatedRevenue);
        return Integer.parseInt(combinedRevenue);
    }
    public static int getWinningsByMatchState(List<Integer> match) {
        WinningsTable winningsTable = WinningsTable.findByMatches(match);

        return WinningsTable.transform(winningsTable.revenue);
    }
    public static int getRaffleMatchesByMatchState(String rankName) {
        WinningsTable winningsTable = WinningsTable.findByRankName(rankName);
        return winningsTable.NUMBER_OF_MATCHES.get(RAFFLE_MATCHES);
    }


}
