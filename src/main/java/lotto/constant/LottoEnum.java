package lotto.constant;

public enum LottoEnum {
    START_NUM(1),
    END_NUM(45),
    SIZE(6);

    private final int value;

    LottoEnum(Integer value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
