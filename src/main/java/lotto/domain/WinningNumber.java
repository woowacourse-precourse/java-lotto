package lotto.domain;

import java.util.List;

public class WinningNumber extends Lotto{
    private int bonusNumber;
    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateContain(numbers, bonusNumber);
        validateOverNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateContain(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 당첨 번호와 달라야합니다.");
        }
    }

    private void validateOverNumber(int bonusNumber) {
        if (outOfRange(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 1이상 45이하의 숫자입니다.");
        }
    }
}
