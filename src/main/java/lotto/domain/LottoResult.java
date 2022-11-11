package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private List<Integer> matches = new ArrayList<>();
    private List<Integer> bonusMatches = new ArrayList<>();

    public LottoResult(List<Integer> winningNumbers, List<List<Integer>> allPlayerNumbers, int bonusNumber) {
        for (List<Integer> playerNumbers : allPlayerNumbers) {
            matches.add(calculateMatch(winningNumbers, playerNumbers));
            bonusMatches.add(calculateBonusMatch(playerNumbers, bonusNumber));
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

    private int calculateBonusMatch(List<Integer> playerNumbers, int bonusNumber) {
        int bonusMatch = 0;
        if (playerNumbers.contains(bonusNumber)) {
            bonusMatch++;
        }
        return bonusMatch;
    }

    public List<Integer> getMatches() {
        return matches;
    }

    public List<Integer> getBonusMatches() {
        return bonusMatches;
    }
}
