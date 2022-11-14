package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;

public class Result {
    public static LinkedHashMap<Rank, Integer> getWinningResult(final List<Integer> matchResult, final List<Boolean> hasBonus) {
        LinkedHashMap<Rank, Integer> result = initResult();
        for (int i = 0; i < matchResult.size(); i++) {
            int match = matchResult.get(i);
            boolean bonus = hasBonus.get(i);
            Rank rank = Rank.find(match);
            result.put(checkRank(match, bonus, rank), result.get(Rank.find(match)) + 1);
        }
        return result;
    }

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
