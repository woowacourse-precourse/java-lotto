package lotto.utils.constants;

public enum IntegerCommon {


    MAX_PERCENTAGE(100),
    MOD(0),
    ZERO(0),
    COUNT(1),
    ROUND_MULTIPLICATION(10);

    private final int number;

    IntegerCommon(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
