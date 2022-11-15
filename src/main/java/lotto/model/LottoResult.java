package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private List<Integer> matches = new ArrayList<>();
    private List<Boolean> hasBonusMatches = new ArrayList<>();

    public LottoResult(List<Integer> winningNumbers, int bonusNumber, List<List<Integer>> allPlayerNumbers) {
        for (List<Integer> playerNumbers : allPlayerNumbers) {
            matches.add(calculateMatch(winningNumbers, playerNumbers));
            hasBonusMatches.add(hasBonusNumber(playerNumbers, bonusNumber));
        }
    }

    private int calculateMatch(List<Integer> winningNumbers, List<Integer> playerNumbers) {
        int match = 0;
        for (int playerNumber : playerNumbers) {
            if (winningNumbers.contains(playerNumber)) {
                match++;
            }
        }
        return match;
    }

    private boolean hasBonusNumber(List<Integer> playerNumbers, int bonusNumber) {
        boolean hasBonus = false;
        if (playerNumbers.contains(bonusNumber)) {
            hasBonus = true;
        }
        return hasBonus;
    }

    public List<Integer> getMatches() {
        return matches;
    }

    public List<Boolean> getBonusMatches() {
        return hasBonusMatches;
    }
}
