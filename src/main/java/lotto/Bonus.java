package lotto;

import java.util.List;

public class Bonus {

    private final Integer number;

    public Bonus(List<Integer> winningNumbers, Integer bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.number = bonusNumber;
    }

    public Integer getNumber() {
        return number;
    }

    private void validate(List<Integer> winningNumbers, Integer bonusNumber) {
        checkRangeOfNumber(bonusNumber);
        validateBonusNumber(winningNumbers, bonusNumber);
    }

    private void checkRangeOfNumber(Integer number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자의 범위는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 말아야 합니다.");
        }
    }
}
