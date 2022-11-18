package lotto.domain;

import lotto.constants.ErrorMessages;

import java.util.List;

public class Winning {
    List<Integer> winningNumbers;
    int bonus;

    public Winning(List<Integer> winningNumbers, int bonus) {
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
        validateBonus();
    }

    public WinningTable calMyScore(Lotto lotto) {
        int correctedCount = lotto.matchCount(winningNumbers);
        boolean containsBonus = lotto.containsBonus(bonus);

        return WinningTable.getRank(correctedCount, containsBonus);
    }


    private void validateBonus() {
        if (checkBonusDuplicate(winningNumbers, bonus)) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_DUPLICATE);
        }
    }

    private boolean checkBonusDuplicate(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
