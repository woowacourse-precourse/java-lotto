package lotto.domain;

public class Bonus {
    private final int bonusNumber;

    public Bonus(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (Lotto.MINIMUM_NUMBER > bonusNumber || bonusNumber > Lotto.MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(Error.bonus.value());
        }
    }
}
