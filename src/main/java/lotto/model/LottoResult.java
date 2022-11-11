package lotto.model;

import java.util.List;

public class LottoResult {
    private int countSame;

    public LottoResult(List<Integer> winningNumbers, List<Integer> playerNumbers) {
        countSame = 0;
        for (Integer playerNumber : playerNumbers) {
            if (winningNumbers.contains(playerNumber)) {
                countSame++;
            }
        }
    }

    public int get() {
        return countSame;
    }
}
