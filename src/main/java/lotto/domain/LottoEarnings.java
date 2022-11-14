package lotto.domain;

import java.util.List;

public class LottoEarnings {
    public static int calculatePrize(final List<Integer> matchResult, final List<Boolean> hasBonus) {
        int prize = 0;
        for (int i = 0; i < matchResult.size(); i++) {
            int matchNumber = matchResult.get(i);
            boolean bonus = hasBonus.get(i);
            prize += checkRank(matchNumber, bonus);
        }
        return prize;
    }

    private static int checkRank(final int match, final boolean hasBonus) {
        if (match == Rank.FIVE.matchNumber() && !hasBonus) {
            return Rank.FIVE.prize();
        }
        if (match == Rank.FIVE_AND_BONUS.matchNumber() && hasBonus) {
            return Rank.FIVE_AND_BONUS.prize();
        }
        return Rank.find(match).prize();
    }
}
