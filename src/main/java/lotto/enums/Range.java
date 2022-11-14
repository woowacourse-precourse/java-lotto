package lotto.enums;

public enum Range {
    MAX_RANGE(45),
    MIN_RANGE(1),
    DIGIT(6),
    PRICE(1000),
    CORRECT_CASE(5);

    public final int range;

    Range(int range) {
        this.range = range;
    }

    public int get() {
        return range;
    }


}
