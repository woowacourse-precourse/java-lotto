package lotto.domain;

import lotto.constants.ErrorMessages;
import lotto.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class Winning {
    List<Integer> winningNumbers;
    int bonus;

    public Winning(List<Integer> winningNumbers, int bonus) {
        validateNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        validateBonus(bonus);
        this.bonus = bonus;
    }

    public List<WinningTable> getWinningInfo(List<Lotto> lottos) {
        List<WinningTable> winningInfo = new ArrayList<>();
        for (Lotto lotto : lottos) {
            WinningTable winningTable = calMyScore(lotto);
            winningInfo.add(winningTable);
        }
        return winningInfo;
    }

    private WinningTable calMyScore(Lotto lotto) {
        int correctedCount = lotto.matchCount(winningNumbers);
        boolean containsBonus = lotto.containsBonus(bonus);

        return WinningTable.getRank(correctedCount, containsBonus);
    }

    private void validateNumbers(List<Integer> winningNumbers) {
        if (Validator.checkSize(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessages.SIZE);
        }

        if (Validator.hasDuplicate(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE);
        }

        if (Validator.checkRange(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessages.RANGE);
        }
    }
    private void validateBonus(int bonus) {
        if (Validator.hasDuplicate(winningNumbers, bonus)) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_DUPLICATE);
        }
    }

}
