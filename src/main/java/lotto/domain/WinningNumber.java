package lotto.domain;

import java.util.List;

public class WinningNumber extends Lotto {
    private int bonusNumber;

    public WinningNumber(List<Integer> numbers) {
        super(numbers);
    }

    public void setBonusNumber(int bonusNumber) {
        validateRange(bonusNumber);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    void validateBonusNumber(int number) {
        if (getNumbers().contains(number)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 겹칩니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
