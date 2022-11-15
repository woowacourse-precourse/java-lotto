package lotto;

public class Bonus {
    private final int number;

    public Bonus(int number, Lotto lotto) {
        validate(number, lotto);
        this.number = number;
    }

    private void validate(int number, Lotto lotto) {
        if (!isValidRange(number)) {
            throw new IllegalArgumentException();
        }
        if (hasSameNumber(number, lotto)) {
            throw new IllegalArgumentException();
        }
    }

    private Boolean isValidRange(int number) {
        if (number < 1 || number > 45) {
            return false;
        }
        return true;
    }

    private Boolean hasSameNumber(int number, Lotto lotto) {
        for (int comparedNumber : lotto.getNumbers()) {
            if (number == comparedNumber) {
                return true;
            }
        }
        return false;
    }

    public int getNumber() {
        return number;
    }
}
