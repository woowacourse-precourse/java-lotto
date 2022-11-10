package constant;

public enum LottoNumber {
    SIZE(6),
    ;

    private final int value;

    LottoNumber(int value) {
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
