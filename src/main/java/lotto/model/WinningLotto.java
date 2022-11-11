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
        validateWinningNumbers(winningNumbers);
        validateBonusNumber(bonusNumber, winningNumbers);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateSize(winningNumbers);
        validateDuplication(winningNumbers);
        validateRange(winningNumbers);
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호의 개수는 6개 이어야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> winningNumbers) {
        Set<Integer> removeDuplication = new HashSet<>(winningNumbers);
        if (winningNumbers.size() != removeDuplication.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호들은 중복될 수 없습니다.");
        }
    }

    private void validateRange(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateBonusNumber(BonusNumber bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
