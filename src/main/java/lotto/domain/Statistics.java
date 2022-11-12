package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Statistics {
    private static List<Integer> matches = new ArrayList<>();
    private static List<Boolean> bonusMatches = new ArrayList<>();
    private static List<Rank> statistics = new ArrayList<>();

    public Statistics(List<Integer> matches, List<Boolean> bonusMatches) {
        this.matches = matches;
        this.bonusMatches = bonusMatches;
    }

    public static void setStatistics(List<Integer> matches, List<Boolean> bonusMatches) {
        for (int i = 0; i < matches.size(); i++) {
            statistics.add(findRank(matches.get(i), bonusMatches.get(i)));
        }
    }

    public static Rank findRank(int match, boolean hasBonus) {
        if (match == 5) {
            if (hasBonus) {
                return Rank.SECOND;
            }
            return Rank.THIRD;
        }
        return Arrays.stream(Rank.values()).filter(rank -> rank.getMatch() == match).findAny().orElse(Rank.NONE);
    }
}
