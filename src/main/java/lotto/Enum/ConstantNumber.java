package lotto.Enum;

public enum ConstantNumber {
    ZERO(0),
    SIX(6),
    FOURTY_FIVE(45),
    THOUSAND(1000),
    HUNDRED_THOUSAND(100000),
    ;

    final private int value;

    ConstantNumber(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
