package lotto.domain;

import java.util.LinkedHashMap;

public class Result {
    private static LinkedHashMap<Rank, Integer> initResult() {
        LinkedHashMap<Rank, Integer> result = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        return result;
    }

    private static Rank checkRank(final int matchNumber, final boolean hasBonus, Rank rank) {
        if (matchNumber == Rank.FIVE.matchNumber() && !hasBonus) {
            return Rank.FIVE;
        }
        if (matchNumber == Rank.FIVE_AND_BONUS.matchNumber() && hasBonus) {
            return Rank.FIVE_AND_BONUS;
        }
        return rank;
    }
}
