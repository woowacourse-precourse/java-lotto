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
}
