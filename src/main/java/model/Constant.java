package model;

public enum Constant {
    ZERO(0),
    START_INCLUSIVE(1),
    REPETITION(1),
    END_INCLUSIVE(45),
    BOUNDS(6),
    FIVE_MATCH_NUMBER(5),
    ONE_HUNDRED_FOR_PERCENT(100),
    MINIMUM_LOTTO_PRICE(1000);

    public final int constant;

    Constant(int constant) {
        this.constant = constant;
    }
}
