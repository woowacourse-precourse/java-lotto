package constant;

public enum LottoRule {
    SIZE(6),
    START_NUMBER(1),
    END_NUMBER(45),
    ;

    private final int value;

    LottoRule(int value) {
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
