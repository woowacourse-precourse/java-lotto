package lotto.model;

import java.util.List;

public class LottoResult {
    private int countSame;
    private int bonusSame;


    public LottoResult(List<Integer> winningNumbers, List<Integer> playerNumbers, int bonusNumber) {
        for (Integer playerNumber : playerNumbers) {
            if (winningNumbers.contains(playerNumber)) {
                countSame++;
                if (countSame == 5 && playerNumbers.contains(bonusNumber)) {
                    bonusSame++;
                }
            }
        }
        countSame -= bonusSame;
    }

    public int getCountSame() {
        return countSame;
    }

    public int getBonusSame() {
        return bonusSame;
    }
}
