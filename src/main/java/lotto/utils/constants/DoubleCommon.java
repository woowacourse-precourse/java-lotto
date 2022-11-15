package lotto.utils.constants;

public enum DoubleCommon {

    ZERO_DOUBLE(0.0),
    ROUND_DIVISOR(10.0);

    private final double fixer;

    DoubleCommon(final double fixer) {
        this.fixer = fixer;
    }

    public double getFixer() {
        return fixer;
    }
}
