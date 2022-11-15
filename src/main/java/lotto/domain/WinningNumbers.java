package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> sixNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> sixNumbers, int bonusNumber) {
        this.sixNumbers = sixNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getSixNumbers() {
        return sixNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
