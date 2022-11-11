package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final BonusNumber bonusNumber;

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }

    public WinningLotto(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        validateBonusNumber(bonusNumber, winningNumbers);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(BonusNumber bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
