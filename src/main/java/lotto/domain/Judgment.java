package lotto.domain;

import java.util.List;

public class Judgment {
    public int compareToNumber(List<Integer> myNumber, List<Integer> winningNumber) {
        int winCount = 0;
        for (int i : myNumber) {
            if (winningNumber.contains(i)) {
                winCount++;
            }
        }
        return winCount;
    }
}
