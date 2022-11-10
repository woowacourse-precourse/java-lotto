package lotto.domain;

import java.util.List;

public class Judgment {
    public int compare(List<Integer> winningNumber, List<Integer> playerNumber) {
        int matchNumber = 0;
        for (int number : playerNumber) {
            if (winningNumber.contains(number)) {
                matchNumber++;
            }
        }

        return matchNumber;
    }

    public boolean hasBonusNumber(List<Integer> winningNumber, int bonusNumber) {
        return winningNumber.contains(bonusNumber);
    }
}
