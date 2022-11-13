package lotto.domain;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        this.number=number;
    }

    public boolean isBonusNumber(int other) {
        if (other == number) {
            return true;
        }
        return false;
    }
}
