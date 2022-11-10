package lotto.domain;

import java.util.List;

public class WinningLotto {

    private static final String WINNING_NUMBERS_ARE_BETWEEN_ONE_AND_FORTY_FIVE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.";

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (!isBetweenOneAndFortyFive(winningNumbers)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_ARE_BETWEEN_ONE_AND_FORTY_FIVE);
        }
    }

    private boolean isBetweenOneAndFortyFive(List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            if (winningNumber < 1 || winningNumber > 45) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
