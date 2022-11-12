package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private static final String ERROR_NUMBER_EXISTS = "[ERROR] 당첨번호에 존재하는 번호입니다.";

    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void validate(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_NUMBER_EXISTS);
        }
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }

}
