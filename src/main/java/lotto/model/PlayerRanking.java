package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerRanking {
    private List<Rank> playerRankings = new ArrayList<>();

    public PlayerRanking(List<Integer> matches, List<Boolean> bonusMatches) {
        setPlayerRankings(matches, bonusMatches);
    }

    private void setPlayerRankings(List<Integer> matches, List<Boolean> bonusMatches) {
        for (int index = 0; index < matches.size(); index++) {
            Rank playerRanking = findPlayerRanking(matches.get(index), bonusMatches.get(index));
            playerRankings.add(playerRanking);
        }
    }

    private static Rank findPlayerRanking(int match, boolean hasBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatch() == match)
                .filter(rank -> rank.getHasBonus().contains(hasBonus))
                .findAny()
                .orElse(Rank.NONE);
    }

    public List<Rank> getPlayerRankings() {
        return playerRankings;
    }

}
