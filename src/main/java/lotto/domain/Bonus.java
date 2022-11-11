package lotto.domain;

public class Bonus {
    private static int bonusNumber;

    public Bonus(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static int getBonusNumber() {
        return bonusNumber;
    }
}
