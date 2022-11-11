package lotto.model;

import java.util.List;

public class LottoResult {
    private int countMatch;
    private int bonusMatch;


    public LottoResult(List<Integer> winningNumbers, List<Integer> playerNumbers, int bonusNumber) {
        for (Integer playerNumber : playerNumbers) {
            if (winningNumbers.contains(playerNumber)) {
                countMatch++;
                if (countMatch == 5 && playerNumbers.contains(bonusNumber)) {
                    bonusMatch++;
                }
            }
        }
        countMatch -= bonusMatch;
    }

    public int getCountMatch() {
        return countMatch;
    }

    public int getBonusMatch() {
        return bonusMatch;
    }
}
