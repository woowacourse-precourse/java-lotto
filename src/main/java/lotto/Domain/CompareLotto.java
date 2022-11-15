package lotto.Domain;

import java.util.List;

public class CompareLotto {
    private int theNumberOfWins = 0;
    private int winningBonus = 0;

    public void addTheNumberOfWins(List<Integer> lotto, List<Integer> userInputLotto) {
        for (int index : userInputLotto) {
            if (lotto.contains(index)) {
                theNumberOfWins++;
            }
        }
    }

    public void addWinningBonus(List<Integer> lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            winningBonus++;
        }
    }

    public int getTheNumberOfWins() {
        return this.theNumberOfWins;
    }

    public int getWinningBonus() {
        return this.winningBonus;
    }
}
