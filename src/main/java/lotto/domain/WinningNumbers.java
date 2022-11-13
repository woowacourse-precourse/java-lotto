package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final String DUPLICATE_NUMBER_ERROR = "[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.";
    private final List<Integer> winningNubers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNubers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    // 당첨 번호와 보너스 번호가 다른지 파악

    public void validateDuplicateNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
        }
    }
}
