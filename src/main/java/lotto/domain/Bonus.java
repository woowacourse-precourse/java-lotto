package lotto.domain;

public class Bonus {
    private final int bonusNumber;

    Bonus(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (Lotto.MINIMUM_NUMBER <= bonusNumber && bonusNumber <= Lotto.MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
