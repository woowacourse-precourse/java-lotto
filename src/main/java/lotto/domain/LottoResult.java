package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private List<Integer> matches = new ArrayList<>();
    private List<Boolean> bonusMatches = new ArrayList<>();

    public LottoResult(List<Integer> winningNumbers, List<List<Integer>> allPlayerNumbers, int bonusNumber) {
        for (List<Integer> playerNumbers : allPlayerNumbers) {
            matches.add(calculateMatch(winningNumbers, playerNumbers));
            bonusMatches.add(hasBonusNumber(playerNumbers, bonusNumber));
        }
        System.out.println("Match: " + matches);
        System.out.println("Bonus: " + bonusMatches);
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
        boolean bonus = false;
        if (playerNumbers.contains(bonusNumber)) {
            bonus = true;
        }
        return bonus;
    }

    public List<Integer> getMatches() {
        return matches;
    }

    public List<Boolean> getBonusMatches() {
        return bonusMatches;
    }
}
