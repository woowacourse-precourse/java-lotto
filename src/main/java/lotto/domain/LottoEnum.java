package lotto.domain;

public enum LottoEnum {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LENGTH(6);

    private final int value;

    LottoEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean isNumberInRange(int number) {
        return (number >= MIN_NUMBER.value) && (number <= MAX_NUMBER.value);
    }
}
