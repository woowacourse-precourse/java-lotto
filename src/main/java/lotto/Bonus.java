package lotto;

import java.util.List;

public class Bonus {
    private final int bonusNumber;

    public Bonus(int bonusNumber, List<Integer> numbers) {
        validate(bonusNumber, numbers);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber, List<Integer> numbers) {
        if (1 > bonusNumber || 45 < bonusNumber) {
            throw new IllegalArgumentException("보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
        for (Integer number : numbers) {
            if (number.equals(bonusNumber)) {
                throw new IllegalArgumentException("보너스 번호는 당첨번호와 중복될 수 없습니다.");
            }
        }
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
