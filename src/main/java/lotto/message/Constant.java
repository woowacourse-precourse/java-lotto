package lotto.message;

public enum Constant {
    START_NUMBER(1),
    END_NUMBER(45),
    PRICE(1000),
    NUMBER_SIZE(6);

    private final int constant;

    Constant(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }
}
