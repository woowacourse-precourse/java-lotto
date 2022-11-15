package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Rank {
    FIRST(List.of(6, 0), 2000000000),
    SECOND(List.of(5, 1), 30000000),
    THIRD(List.of(5, 0), 1500000),
    FOURTH(List.of(4, 0), 50000),
    FIFTH(List.of(3, 0), 5000),
    NOTHING(Collections.EMPTY_LIST, 0);
    private final List<Integer> NUMBER_OF_MATCHES;
    private final int revenue;

    Rank(List<Integer> numberOfMatches, int revenue) {
        this.revenue = revenue;
        this.NUMBER_OF_MATCHES = numberOfMatches;
    }

    public static boolean isSame(Rank rank, List<Integer> matches) {
        return Arrays.equals(rank.NUMBER_OF_MATCHES.toArray(), matches.toArray());
    }

    public static Rank findByMatches(List<Integer> matches) {

        return Arrays.stream(Rank.values()).
                filter(rank -> Rank.isSame(rank, matches)).
                findAny().
                orElse(NOTHING);
    }

    public static List<String> getRankNames() {
        List<String> rankName = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            if (!rank.name().equals("NOTHING")) {
                rankName.add(rank.name());
            }
        }
        return rankName;
    }

    public static String getRankNameByMatchState(List<Integer> match) {
        Rank rank = Rank.findByMatches(match);
        return rank.name();
    }

    public static int getWinningsByMatchState(List<Integer> match) {
        Rank rank = Rank.findByMatches(match);
        return rank.revenue;
    }
}
