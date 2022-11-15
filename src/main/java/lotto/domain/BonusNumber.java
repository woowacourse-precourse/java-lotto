package lotto.domain;

public class BonusNumber {
    private int number;

    public BonusNumber(int number) {
        this.number = number;
    }

    public boolean isDuplicate(Lotto lotto) {
        return lotto.contains(number);
    }

    public boolean isMatch(Lotto lotto) {
        return lotto.contains(number);
    }
}
