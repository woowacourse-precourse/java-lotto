package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ranking {
    private List<Integer> matches = new ArrayList<>();
    private List<Boolean> bonusMatches = new ArrayList<>();
    private List<Rank> rankings = new ArrayList<>();

    public Ranking(List<Integer> matches, List<Boolean> bonusMatches) {
        this.matches = matches;
        this.bonusMatches = bonusMatches;
        setRankings(matches, bonusMatches);
    }

    private void setRankings(List<Integer> matches, List<Boolean> bonusMatches) {
        for (int i = 0; i < matches.size(); i++) {
            rankings.add(findRanking(matches.get(i), bonusMatches.get(i)));
        }
    }

    private static Rank findRanking(int match, boolean hasBonus) {
        if (match == Rank.SECOND.getMatch()) {
            if (hasBonus) {
                return Rank.SECOND;
            }
            return Rank.THIRD;
        }
        return Arrays.stream(Rank.values()).filter(rank -> rank.getMatch() == match).findAny().orElse(Rank.NONE);
    }

    public List<Rank> getRankings() {
        return rankings;
    }

}
