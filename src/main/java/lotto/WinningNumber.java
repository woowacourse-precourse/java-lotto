package lotto;

import java.util.List;

public class WinningNumber {
    Lotto number;
    int bonusNumber;

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        number = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }
}
