package lotto.domain.constant;

public enum IntValueConstant {

    LOTTO_MINIMUM_NUMBER(1),
    LOTTO_MAXIMUM_NUMBER(45),
    LOTTO_NUMBER_OF_DIGITS(6);

    final int value;

    IntValueConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
