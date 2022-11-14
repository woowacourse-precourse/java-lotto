package lotto.domain;

import java.util.List;

public class ScoreCalculator {
    private int matching = 0;
    private boolean isMatchingBonus = false;

    public void updateScore(Lotto lotto, WinningLotto winningNumber) {
        List<Integer> numbers = lotto.getNumbers();
        for (Integer number : numbers) {
            updateMatchingScore(number, winningNumber);
            updateIsMatchingBonus(number, winningNumber);
        }
    }

    private void updateMatchingScore(int number, WinningLotto winningNumber) {
        if (winningNumber.isContains(number)) {
            matching++;
        }
    }

    public int getMatching() {
        return matching;
    }

    public boolean isMatchingBonus() {
        return isMatchingBonus;
    }

    private void updateIsMatchingBonus(int number, WinningLotto winningNumber) {
        if (winningNumber.isBonusEqualTo(number)) {
            isMatchingBonus = true;
        }
    }
}
